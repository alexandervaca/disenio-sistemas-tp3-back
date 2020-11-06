package ar.com.ifts.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ar.com.ifts.app.model.Notificacion;

public interface NotificacionRepository extends CrudRepository<Notificacion, Long>{

	public List<Notificacion> findByUsuarioIdUsuario(Long IdUsuario);
}
