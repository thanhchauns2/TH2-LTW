package service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.ProductService;

@Service
public class ProductServiceImplement implements ProductService {
	
	private final ProductRepository productRepository;

    public ProductServiceImplement(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {

        return this.productRepository.findAll();
    }
    
    public Product find(String code) {
    	return this.productRepository.findByCode(code);
    }
    
    public void save(Product product) {
    	this.productRepository.save(product);
    }
    
    @Transactional
    public void delete(String code) {
    	this.productRepository.deleteByCode(code);
    }
}
