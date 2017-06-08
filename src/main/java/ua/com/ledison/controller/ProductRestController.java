package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.service.ProductSpecificationsBuilder;
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
        Pattern pattern = Pattern.compile("\"(\\w+?)(:|>|<|-|=)(\\w+?)\"");
        Matcher matcher = pattern.matcher(search + ",");

        while (matcher.find()) {
            params.add(new SearchCriteria(matcher.group(1), matcher.group(2), matcher.group(3)));
        }

        int pageNumber = Integer.parseInt((String) params.get(0).getValue());

        params.remove(0);

        int j = 0;
        for (int i = 1; i < params.size(); i++) {
            if (params.get(j).getKey().equals(params.get(i).getKey())) {
                params.get(j).setValue(params.get(j).getValue() + ";" + params.get(i).getValue());
                params.remove(i);
                i--;
            } else {
                j++;
            }
        }

        ProductSpecificationsBuilder builder = new ProductSpecificationsBuilder(params);
        Specification<Product> spec = builder.build();

        return productService.findPaginated(spec, pageNumber);
    }

    @PostMapping("/popular")
    public List<Product> getMostPopularProducts() {

        return productService.getMostPopularProductList();
    }

    @PostMapping("/recommended")
    public List<Product> getRecommendedProducts() {

        return productService.getRecommendedProductList();
    }

    @GetMapping(value = "/products/autocomplete")
    public List<Product> autoComplete(@RequestParam String query) {
        List<Product> result = productService.getProductsMatchingSearch(query);

        return result;
    }

}