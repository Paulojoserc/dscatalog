package com.devsuporior.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuporior.dscatalog.entities.Category;
/*@Repository tem a função de resistra como um componete injetavel 
 *agora objetos como CategoryRepository passa ser gerenciado pelo sping */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
