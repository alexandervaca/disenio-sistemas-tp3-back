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
	public void testNuevasCategorias() {
		Categoria entity1 = new Categoria();
		entity1.setDescCategoria("Alimentos");
		categoriaRepository.save(entity1);

		Categoria entity2 = new Categoria();
		entity2.setDescCategoria("Electronica");
		categoriaRepository.save(entity2);
		
		Categoria entity3 = new Categoria();
		entity3.setDescCategoria("Mascotas");
		categoriaRepository.save(entity3);
		
		Categoria entity4 = new Categoria();
		entity4.setDescCategoria("Bebidas");
		categoriaRepository.save(entity4);
	}
}
