package com.example.demo.nhom12.repo;

import java.util.List;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.nhom12.model.Product;

public interface ProductRepository extends CrudRepository<Product, String>{
	List<Product> findAll();
	Product findByID(String ID);
	Product save(Product product);
	void deleteByID(String ID);
}
