package service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import repo.ProductRepo;

import model.Product;

@Service
public class ProductServiceImplement implements ProductService {
	
	private final ProductRepo productRepo;

    public ProductServiceImplement(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public List<Product> findAll() {

        return this.productRepo.ProductList();
    }
    
    public Product find(String ID) {
    	return this.productRepo.findByID(ID);
    }
    
    public void update(Product product) {
    	this.productRepo.save(product);
    }
    
    @Transactional
    public void delete(String ID) {
    	this.productRepo.deleteByID(ID);
    }
}
