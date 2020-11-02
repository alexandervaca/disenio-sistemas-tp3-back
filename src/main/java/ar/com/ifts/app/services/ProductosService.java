package ar.com.ifts.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.ProductoNoExistenteException;
import ar.com.ifts.app.exception.UsuarioNoExistenteException;
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
	
	public Producto obtenerProductoPorId(Long idProducto) throws ProductoNoExistenteException {
		return productosRepository.findById(idProducto).orElseThrow(ProductoNoExistenteException::new);
	}

	public void create(RequestCrearProductoBody requestProductoBody) throws UsuarioNoExistenteException {
		Usuario usuario = usuarioRepository.findById(requestProductoBody.getIdUsuario())
				.orElseThrow(UsuarioNoExistenteException::new);

		Producto producto = new Producto(requestProductoBody.getDescripcion(), requestProductoBody.getPrecio(),
				requestProductoBody.getImagen(), usuario);
		productosRepository.save(producto);
	}

	public void deleteProducto(Long idProducto) throws ProductoNoExistenteException {
		Producto producto = obtenerProductoPorId(idProducto);
		productosRepository.delete(producto);
	}
	
	public void modificarProducto(RequestModificarProductoBody requestModificarProductoBody) throws ProductoNoExistenteException {
		Producto producto = obtenerProductoPorId(requestModificarProductoBody.getIdProducto());
		producto.setDescProducto(requestModificarProductoBody.getDescripcion());
		producto.setImagen(requestModificarProductoBody.getImagen());
		producto.setPrecio(requestModificarProductoBody.getPrecio());
		productosRepository.save(producto);
	}
}
