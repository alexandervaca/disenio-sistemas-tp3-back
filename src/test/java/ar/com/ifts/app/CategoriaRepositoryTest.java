package ar.com.ifts.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.repository.CategoriaRepository;

@SpringBootTest
public class CategoriaRepositoryTest {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Test
	public void testNuevaCategoria() {
		Categoria entity = new Categoria();
		entity.setDescCategoria("Indumentaria");
		categoriaRepository.save(entity);

		Assertions.assertNotNull(entity.getIdCategoria());

		System.out.println(entity.getDescCategoria());
	}
}
