package ar.com.ifts.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Categoria;

@Repository
public interface CategoriaRepository extends CrudRepository<Categoria, Long> {
	
	public Categoria findByDescCategoria(String descCategoria);
	
}
