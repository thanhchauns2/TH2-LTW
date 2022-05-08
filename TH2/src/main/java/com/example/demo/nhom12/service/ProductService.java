package com.example.demo.nhom12.service;

import org.hibernate.service.Service;

import com.example.demo.nhom12.model.Product;

import java.util.List;


public interface ProductService extends Service {
	List<Product> findAll();
	void save(Product product);
	Product find(String ID);
	void delete(String ID);
}
