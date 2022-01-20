package com.devsuporior.dscatalog.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuporior.dscatalog.entities.Category;
import com.devsuporior.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoriaResource {
	/*Autowired injeta automaticamente as dependencias */
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){
		List<Category> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
}
