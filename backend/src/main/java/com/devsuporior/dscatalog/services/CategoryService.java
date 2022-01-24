package com.devsuporior.dscatalog.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuporior.dscatalog.dto.CategoryDTO;
import com.devsuporior.dscatalog.entities.Category;
import com.devsuporior.dscatalog.repositories.CategoryRepository;
import com.devsuporior.dscatalog.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

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
	@Transactional(readOnly = true)
	public CategoryDTO findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entidade não encontrada"));
		return new CategoryDTO(entity);
	}
	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	@Transactional
	public CategoryDTO update(Long id, CategoryDTO dto) {
		try {
		Category entity = repository.getOne(id);
		entity.setNome(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
		}	
		catch (EntityNotFoundException e ) {
			throw new ResourceNotFoundException("Id not found "+ id);
		}
		
	}
}
