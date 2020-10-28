package ar.com.ifts.app;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ifts.app.model.Compra;
import ar.com.ifts.app.model.CompraProducto;
import ar.com.ifts.app.model.Producto;
import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.repository.CompraRepository;
import ar.com.ifts.app.repository.ProductoRepository;
import ar.com.ifts.app.repository.UsuarioRepository;

@SpringBootTest
public class CompraRepositoryTest {

	@Autowired
	private CompraRepository compraRepository;

	@Autowired
	private ProductoRepository productoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Test
	public void testNuevCompra() {
		Optional<Usuario> usuarioOptional = usuarioRepository.findById(10L);
		Usuario usuario = usuarioOptional.isPresent() ? usuarioOptional.get() : null;

		Compra compra = new Compra();
		compra.setUsuario(usuario);
		compra.setFechaCompra(LocalDateTime.now());
		compra.setPrecioTotal(BigDecimal.ZERO);

		compraRepository.save(compra);
		Assertions.assertNotNull(compra.getIdCompra());

		Optional<Producto> productoOptional = productoRepository.findById(1L);
		Producto producto = productoOptional.isPresent() ? productoOptional.get() : null;
		Assertions.assertNotNull(producto);

		CompraProducto compraProducto = new CompraProducto();
		compraProducto.setProducto(producto);
		compraProducto.setCantProducto(3);
		compraProducto.setPrecioProducto(producto.getPrecio().multiply(BigDecimal.valueOf(compraProducto.getCantProducto().longValue())));
		
		compra.addProducto(compraProducto);
		compraRepository.save(compra);
		Assertions.assertNotNull(compra.getIdCompra());
	}

}
