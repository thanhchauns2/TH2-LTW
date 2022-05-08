package com.example.demo.nhom12.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.nhom12.model.Product;
import com.example.demo.nhom12.repo.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

    public ProductServiceImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {

        return this.productRepository.findAll();
    }
    
    public Product find(String ID) {
    	return this.productRepository.findByID(ID);
    }
    
    public void save(Product product) {
    	this.productRepository.save(product);
    }
    
    @Transactional
    public void delete(String ID) {
    	this.productRepository.deleteByID(ID);
    }
}
