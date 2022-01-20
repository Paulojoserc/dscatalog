package com.devsuporior.dscatalog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuporior.dscatalog.dto.CategoryDTO;
import com.devsuporior.dscatalog.entities.Category;
import com.devsuporior.dscatalog.repositories.CategoryRepository;

/*@Service Ela vai registrar a class como um componente que vai participa do sistema de injeção do sistema de 
de gestão de independência automatizado do spring quer dizer quem vai gerenciar as instancias das  
dependências  dos objetos categoria service vai ser o spring */
@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	// @Transactional serve para fazer trnsação com banco de dados
	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();

		return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
		/*
		 * Modo verboso List<CategoryDTO> listDto = new ArrayList<>(); for (Category cat
		 * : list) { listDto.add(new CategoryDTO(cat));
		 */
	}
	// return listDto;
}
