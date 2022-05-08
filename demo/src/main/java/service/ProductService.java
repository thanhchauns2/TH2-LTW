package service;

import org.hibernate.service.Service;
import model.Product;
import java.util.List;

public interface ProductService extends Service {
	List<Product> ProductsList();
	void update(Product product);
	Product find(String ID);
	void delete(String ID);
}
