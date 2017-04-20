package ua.com.ledison.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.dao.ProductSpecificationsBuilder;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.ProductService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@PostMapping("/product/productList/all/{pageNumber}")
	public Page<Product> getProductResult(HttpServletRequest searchParams) {

//		Gson gson = new Gson();
//		String search = gson.fromJson(searchParams.toString(), String.class);

		System.out.println("searchParams : " + searchParams);
		ProductSpecificationsBuilder productSpecificationsBuilder = new ProductSpecificationsBuilder();

		int pageNumber = 1;
		Specification<Product> spec = null;

		Page<Product> page = productService.findPaginated(spec, pageNumber);

		return page;
	}
}
