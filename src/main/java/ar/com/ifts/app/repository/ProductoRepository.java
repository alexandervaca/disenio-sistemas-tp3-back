package ar.com.ifts.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Producto;

@Repository
public interface ProductoRepository extends CrudRepository<Producto, Long> {
	
	public Producto findByDescProducto(String descProducto);
	
}
