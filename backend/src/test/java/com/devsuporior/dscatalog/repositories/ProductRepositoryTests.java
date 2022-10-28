package com.devsuporior.dscatalog.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devsuporior.dscatalog.entities.Product;

@SpringBootTest
public class ProductRepositoryTests {
	
	@Autowired
	private ProductRepository repository;
	@Test
	public void deleteShouldDeleteObjectWhenIdExists() {
		
		long exintingId = 1L;
		repository.deleteById(exintingId);
		
		Optional<Product> result = repository.findById(exintingId);
		Assertions.assertFalse(result.isPresent());
	}
}
