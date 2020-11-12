package ar.com.ifts.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.CompraProducto;

@Repository
public interface CompraProductoRepository extends CrudRepository<CompraProducto, Long> {
	
	public List<CompraProducto> findByIdCompra(Long idCompra);
}
