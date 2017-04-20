package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.ProductService;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public Page<Product> getProductResult(@RequestBody String str) {
		System.out.println(str);

		System.out.println("searchParams: " + str);
//		ProductSpecificationsBuilder productSpecificationsBuilder = new ProductSpecificationsBuilder();

		int pageNumber = 1;
		Specification<Product> spec = null;

		Page<Product> page = productService.findPaginated(spec, pageNumber);

		return page;
	}
}
