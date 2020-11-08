package ar.com.ifts.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.ProductosServiceException;
import ar.com.ifts.app.model.Producto;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.input.RequestCrearProductoBody;
import ar.com.ifts.app.model.input.RequestModificarProductoBody;
import ar.com.ifts.app.repository.ProductoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@Service
public class ProductosService {

	@Autowired
	private ProductoRepository productosRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Producto> getProductos() {
		return productosRepository.findAll();
	}

	public Producto obtenerProductoPorId(Long idProducto) throws ProductosServiceException {
		return productosRepository.findById(idProducto)
				.orElseThrow(() -> new ProductosServiceException("Producto inexistente."));
	}

	@Transactional(rollbackOn = {IllegalArgumentException.class, ProductosServiceException.class})
	public void create(RequestCrearProductoBody requestProductoBody) throws ProductosServiceException {
		Usuario usuario = usuarioRepository.findById(requestProductoBody.getIdProveedor())
				.orElseThrow(() -> new ProductosServiceException("Proveedor inexistente."));

		Producto producto = new Producto(requestProductoBody.getDescripcion(), requestProductoBody.getPrecio(),
				requestProductoBody.getStock(), requestProductoBody.getImagen(), usuario);
		productosRepository.save(producto);
	}

	@Transactional(rollbackOn = {IllegalArgumentException.class})
	public void deleteProducto(Long idProducto) throws ProductosServiceException {
		Producto producto = obtenerProductoPorId(idProducto);
		productosRepository.delete(producto);
	}

	@Transactional(rollbackOn = {IllegalArgumentException.class})
	public void modificarProducto(RequestModificarProductoBody requestModificarProductoBody)
			throws ProductosServiceException {
		Producto producto = obtenerProductoPorId(requestModificarProductoBody.getIdProducto());
		producto.setDescProducto(requestModificarProductoBody.getDescripcion());
		producto.setImagen(requestModificarProductoBody.getImagen());
		producto.setPrecio(requestModificarProductoBody.getPrecio());
		producto.setStock(requestModificarProductoBody.getStock());
		productosRepository.save(producto);
	}
}
