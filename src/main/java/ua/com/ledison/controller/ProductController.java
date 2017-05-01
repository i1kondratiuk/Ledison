package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.CapType;
import ua.com.ledison.entity.GlowColor;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.ProductManufacturer;
import ua.com.ledison.service.GlowColorService;
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
	@Autowired
	private GlowColorService glowColorService;

	@GetMapping("/productList/all")
	public String getProducts(Model model) {
		System.out.println("@GetMapping(\"/productList/all\")");
		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();
		List<GlowColor> glowColors = glowColorService.getGlowColorList();

		model.addAttribute("productManufacturers", productManufacturers);
		model.addAttribute("capTypes", CapType.values());
		model.addAttribute("glowColors", glowColors);

		return "productList";
	}

	@GetMapping("/viewProduct/{productId}")
	public String viewProduct(@PathVariable int productId, Model model) throws IOException {
		Product product = productService.getProductById(productId);
		model.addAttribute("product", product);

		return "viewProduct";
	}
}