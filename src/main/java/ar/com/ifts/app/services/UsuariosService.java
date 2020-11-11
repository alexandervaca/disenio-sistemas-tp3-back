package ar.com.ifts.app.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.auth.services.JwtService;
import ar.com.ifts.app.exception.UsuarioServiceException;
import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Permiso;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.enums.PermisosEnum;
import ar.com.ifts.app.repository.CategoriaRepository;
import ar.com.ifts.app.repository.PermisoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@Service
public class UsuariosService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private PermisoRepository permisoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private JwtService jwtService;

	public List<Usuario> getProveedoresByCategoria(Long idCategoria) throws UsuarioServiceException {
		Permiso permiso = permisoRepository.findByDescPermiso(PermisosEnum.PROVEEDOR.getRole());
		Categoria categoria = categoriaRepository.findByIdCategoria(idCategoria)
				.orElseThrow(() -> new UsuarioServiceException("Categoría inexistente."));
		return usuarioRepository.findByPermisoAndCategoria(permiso, categoria);
	}

	public List<Usuario> getProveedores() {
		return this.getUsuariosByPermiso(PermisosEnum.PROVEEDOR.getRole());
	}

	public List<Usuario> getClientes() {
		return this.getUsuariosByPermiso(PermisosEnum.CLIENTE.getRole());
	}

	public List<Usuario> getAdministradores() {
		return this.getUsuariosByPermiso(PermisosEnum.ADMIN.getRole());
	}

	public List<Usuario> getAllUsuarios(HttpServletRequest http) {
		String username = jwtService.getUsernameFromToken((String) http.getHeader("Authorization"));
		return this.usuarioRepository.findAll().stream().filter(elem -> !elem.getUsername().equals(username))
				.collect(Collectors.toList());
	}

	public Usuario getUsuario(HttpServletRequest http) throws UsuarioServiceException {
		String username = jwtService.getUsernameFromToken((String) http.getHeader("Authorization"));
		return usuarioRepository.findByUsername(username)
				.orElseThrow(() -> new UsuarioServiceException("Usuario inexistente."));
	}

	public List<Usuario> getUsuariosByPermiso(String role) {
		return usuarioRepository.findByPermiso(permisoRepository.findByDescPermiso(role));
	}
}
