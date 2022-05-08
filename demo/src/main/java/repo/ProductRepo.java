package repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Product;

public interface ProductRepo extends JpaRepository<Product, String>{
	List<Product> ProductList();
	Product findByID(String ID);
	Product save(Product product);
	void deleteByID(String ID);
}
