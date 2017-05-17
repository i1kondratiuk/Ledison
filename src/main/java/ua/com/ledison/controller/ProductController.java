package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.ProductManufacturerService;
import ua.com.ledison.service.ProductService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductManufacturerService productManufacturerService;

	@GetMapping("/productList/all")
	public String getProducts(Model model) {
		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();

		model.addAttribute("productManufacturers", productManufacturers);
		model.addAttribute("capTypes", CapType.values());
		model.addAttribute("glowColors", GlowColor.values());
		model.addAttribute("lampShapes", LampShape.values());

		return "productList";
	}

	@GetMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);

		return "viewProduct";
	}

	@GetMapping("/viewProduct/{productName}")
	public String findProductByNameAndViewProduct(@PathVariable String productName, Model model) throws IOException {
		Product product = productService.getProductByName(productName);
		model.addAttribute("product", product);

		return "viewProduct";
	}

	@PostMapping("/search")
	@ResponseBody
	public List<Product> search(@RequestBody String searchString) {

		return productService.getProductsMatchingSearch(searchString);
	}
}