package controller;

import model.Product;
import service.ProductServiceImplement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(path = "productMaint1")
public class ProductController {
	@Autowired
	private ProductServiceImplement productServiceImplement;

	@GetMapping(value = "")
	public String home() {
		return "index";
	}

	@GetMapping(value = "displayProducts")
	public String viewProducts(Model model) {
		List<Product> products = this.productServiceImplement.ProductsList();
		model.addAttribute("products", products);
		return "products";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("product", new Product("", "", 0));
		return "add";
	}

	@PostMapping("/add")
	public String addProduct(Product product) {
		this.productServiceImplement.update(product);
		return "redirect:/productMaint1/displayProducts";
	}

	@GetMapping("/update")
	public String showEditForm(@RequestParam String code, Model model) {
		Product product = this.productServiceImplement.find(code);
		model.addAttribute("product", product);
		return "edit";
	}

	@PostMapping("/update")
	public String updateProduct(Product product) {
		this.productServiceImplement.update(product);
		return "redirect:/productMaint1/displayProducts";
	}
	
	@GetMapping("/confirm")
	public String confirm(@RequestParam String code, Model model) {
		Product product = this.productServiceImplement.find(code);
		model.addAttribute("product", product);
		return "confirm";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam String code, Model model) {
		this.productServiceImplement.delete(code);
		return "redirect:/productMaint1/displayProducts";
	}
	
	
}