package ar.com.ifts.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.exception.CreateException;
import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Producto;
import ar.com.ifts.app.model.input.RequestProductoBody;
import ar.com.ifts.app.repository.CategoriaRepository;
import ar.com.ifts.app.repository.ProductoRepository;

@Service
public class ProductosService {

	@Autowired
	private ProductoRepository productosRepository;

	@Autowired
	private CategoriaRepository categoriasRepository;
	
	public List<Producto> getProductos() {
		return productosRepository.findAll();
	}

	public void create(RequestProductoBody requestProductoBody) throws CreateException {
		Long idCategoria = requestProductoBody.getIdCategoria();
		Optional<Categoria> optionalCategoria = categoriasRepository.findById(idCategoria);

		if (optionalCategoria.isPresent()) {
			Categoria categoria = optionalCategoria.get();

			Producto producto = new Producto(requestProductoBody.getDescripcion(), requestProductoBody.getPrecio(), categoria);
			productosRepository.save(producto);
		} else {
			throw new CreateException("Categoria no encontrada.");
		}
	}
}
