package ar.com.ifts.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {

}
