package ar.com.ifts.app;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ifts.app.model.Producto;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.repository.ProductoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@SpringBootTest
public class ProductoRepositoryTest {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void testNuevoProductoConCategoria() {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(1L);
		Usuario usuario = usuarioOptional.isPresent() ? usuarioOptional.get() : null;
		Assertions.assertNotNull(usuario);

		Producto producto = new Producto();
		producto.setDescProducto("Pantalon");
		producto.setUsuario(usuario);
		producto.setImagen("prueba.jpg");
		producto.setPrecio(BigDecimal.ZERO);
		productoRepository.save(producto);

		Assertions.assertNotNull(producto.getIdProducto());
		System.out.println(producto.getDescProducto());
	}

	@Test
	public void testFindProducto() {
		Optional<Producto> productoOptional = productoRepository.findById(1L);
		Producto producto = productoOptional.isPresent() ? productoOptional.get() : null;
		Assertions.assertNotNull(producto);
		System.out.println(producto.getDescProducto());
	}
}
