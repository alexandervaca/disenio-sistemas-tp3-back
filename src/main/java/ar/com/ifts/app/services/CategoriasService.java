package ar.com.ifts.app.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.repository.CategoriaRepository;

@Service
public class CategoriasService {

	@Autowired
	private CategoriaRepository categoriasRepository;
	
	public List<Categoria> getCategorias() {
		return categoriasRepository.findAll();
	}
}
