package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.dao.ProductSpecificationsBuilder;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.util.SearchCriteria;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RestController
public class ProductRestController {

	@Autowired
	private ProductService productService;

	@PostMapping("/")
	public Page<Product> getProductResult(@RequestBody String search) {

		ArrayList<SearchCriteria> params = new ArrayList<>();
		System.out.println(search);
		Pattern pattern = Pattern.compile("\"(\\w+?)(:|>|<)(\\w+?)\"");
		Matcher matcher = pattern.matcher(search + ",");

		while (matcher.find()) {
			params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
		}

		for (SearchCriteria param :
				params) {
			System.out.println(param.toString());
		}

		int pageNumber = Integer.parseInt((String) params.get(0).getValue());

		params.remove(0);

		for (SearchCriteria param :
				params) {
			System.out.println(param.toString());
		}

		ProductSpecificationsBuilder builder = new ProductSpecificationsBuilder(params);
		Specification<Product> spec = builder.build();
		System.out.println(spec);

		return productService.findPaginated(spec, pageNumber);
	}
}