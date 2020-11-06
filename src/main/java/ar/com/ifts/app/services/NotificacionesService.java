package ar.com.ifts.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.model.Notificacion;
import ar.com.ifts.app.repository.NotificacionRepository;

@Service
public class NotificacionesService {

	@Autowired
	private NotificacionRepository notificacionRepository;
	
	public List<Notificacion> obtenerNotificacionesPorProveedor(Long proveedorId) {
		return notificacionRepository.findByUsuarioIdUsuario(proveedorId);
	}
}
