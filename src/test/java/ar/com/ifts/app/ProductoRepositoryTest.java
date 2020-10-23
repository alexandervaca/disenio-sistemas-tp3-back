package ar.com.ifts.app;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Producto;
import ar.com.ifts.app.repository.CategoriaRepository;
import ar.com.ifts.app.repository.ProductoRepository;

@SpringBootTest
public class ProductoRepositoryTest {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Test
	public void testNuevoProducto() {
		Optional<Categoria> categoriaOptional = categoriaRepository.findById(1L);
		Categoria categoria = categoriaOptional.isPresent() ? categoriaOptional.get() : null;
		Assertions.assertNotNull(categoria);

		Producto entity = new Producto();
		entity.setDescProducto("Pantalon");
		entity.setCategoria(categoria);
		productoRepository.save(entity);

		Assertions.assertNotNull(entity.getIdProducto());
		System.out.println(entity.getDescProducto() + " " + entity.getCategoria().getDescCategoria());
	}

	@Test
	public void testFindProducto() {
		Optional<Producto> productoOptional = productoRepository.findById(1L);
		Producto producto = productoOptional.isPresent() ? productoOptional.get() : null;
		Assertions.assertNotNull(producto);
		System.out.println(producto.getDescProducto() + " - " + producto.getCategoria().getDescCategoria());
	}
}
