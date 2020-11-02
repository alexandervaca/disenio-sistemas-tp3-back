package ar.com.ifts.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.CategoriaNoExistenteException;
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
	
	public List<Usuario> getProveedoresByCategoria(Long idCategoria) throws CategoriaNoExistenteException {
		Permiso permiso = permisoRepository.findByDescPermiso(PermisosEnum.PROVEEDOR.getRole());
		Categoria categoria = categoriaRepository.findByIdCategoria(idCategoria).orElseThrow(CategoriaNoExistenteException::new);
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
	
	public List<Usuario> getUsuariosByPermiso(String role) {
		return usuarioRepository.findByPermiso(permisoRepository.findByDescPermiso(role));
	}
}
