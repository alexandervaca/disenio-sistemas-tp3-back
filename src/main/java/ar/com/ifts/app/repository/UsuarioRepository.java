package ar.com.ifts.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	public Optional<Usuario> findByUsername(String username);
	
	public Optional<Usuario> findByMail(String mail);
	
	
}
