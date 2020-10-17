package ar.com.ifts.app.auth.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.RegisterException;
import ar.com.ifts.app.model.Permiso;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.enums.PermisosEnum;
import ar.com.ifts.app.model.input.RequestRegisterBody;
import ar.com.ifts.app.repository.PermisoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermisoRepository permisoRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> optUser = usuarioRepository.findByUsername(username);
		if (!optUser.isPresent()) {
			throw new UsernameNotFoundException("Usuario: " + username + " no encontrado");
		} else {
			Usuario usuario = optUser.get();
			return new User(usuario.getUsername(), usuario.getPassword(), usuario.getAuthorities());
		}
	}

	public void registerUser(RequestRegisterBody request) throws RegisterException {
		Optional<Usuario> findByUsername = usuarioRepository.findByUsername(request.getUsername());
		Optional<Usuario> findByMail = usuarioRepository.findByMail(request.getMail());

		if (findByUsername.isPresent() | findByMail.isPresent()) {
			System.out.println(findByUsername.get().getPermisos());
		} else {
			PermisosEnum permiso = PermisosEnum.valueOf(request.getPermiso());
			List<Permiso> permisos = permiso.getRoles().stream().map(rol -> permisoRepository.findByDescPermiso(rol))
					.collect(Collectors.toList());

			Usuario usuario = new Usuario(request.getUsername(),
					BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)), request.getMail(), permiso.isHabilitado(),
					permisos);
			usuarioRepository.save(usuario);
		}
	}

}
