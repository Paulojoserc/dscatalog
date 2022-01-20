package com.devsuporior.dscatalog.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuporior.dscatalog.entities.Category;
import com.devsuporior.dscatalog.repositories.CategoryRepository;
/*@Service Ela vai registrar a class como um componente que vai participa do sistema de injeção do sistema de 
de gestão de independência automatizado do spring quer dizer quem vai gerenciar as instancias das  
dependências  dos objetos categoria service vai ser o spring */ 
@Service 
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
}
