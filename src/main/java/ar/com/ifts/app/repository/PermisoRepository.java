package ar.com.ifts.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.com.ifts.app.model.Permiso;

@Repository
public interface PermisoRepository extends CrudRepository<Permiso, Long>{
	
	public Permiso findByDescPermiso(String descPermiso);
	
}
