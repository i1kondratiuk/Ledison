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

	@PostMapping("/a")
	public Page<Product> getProductResult(@RequestBody String str) {
		System.out.println(" !!!!!!!!!!!!!!!!!!!!!!");
		System.out.println(str);
//		Gson gson = new Gson();
//		String search = gson.fromJson(searchParams.toString(), String.class);

//		System.out.println("searchParams!!! : " + searchParams);
//		ProductSpecificationsBuilder productSpecificationsBuilder = new ProductSpecificationsBuilder();
//
		int pageNumber = 1;
		Specification<Product> spec = null;

		Page<Product> page = productService.findPaginated(spec, pageNumber);
		System.out.println( " +++++++++");

		return page;
	}
}
