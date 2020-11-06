package ar.com.ifts.app.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.RegisterException;
import ar.com.ifts.app.exception.UsuarioNoExistenteException;
import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Permiso;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.enums.PermisosEnum;
import ar.com.ifts.app.model.input.RequestRegisterBody;
import ar.com.ifts.app.repository.CategoriaRepository;
import ar.com.ifts.app.repository.PermisoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermisoRepository permisoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

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
			throw new RegisterException("Usuario o mail existente.");
		} else {
			PermisosEnum permiso = PermisosEnum.valueOf(request.getPermiso());
			Permiso permisoObj = permisoRepository.findByDescPermiso(permiso.getRole());
			Categoria categoria = null;
			if (request.getIdCategoria() != null) {
				categoria = categoriaRepository.findById(request.getIdCategoria()).orElse(null);				
			}

			Usuario usuario = new Usuario(request.getUsername(),
					BCrypt.hashpw(request.getPassword(), BCrypt.gensalt(12)), request.getMail(), permiso.isHabilitado(),
					permisoObj, categoria, request.getNombre());
			usuarioRepository.save(usuario);
		}
	}
	
	public boolean habilitarDeshabilitarUsuario(Long usuarioId) throws UsuarioNoExistenteException {
		Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(UsuarioNoExistenteException::new);
		usuario.setHabilitado(!usuario.isHabilitado());
		return usuarioRepository.save(usuario).isHabilitado();
	}

}
