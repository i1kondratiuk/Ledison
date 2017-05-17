package ua.com.ledison.service;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import ua.com.ledison.entity.Product;

import java.util.List;

public interface ProductService {

    Page<Product> findPaginated(Specification<Product> spec, Integer pageNumber);

    List<Product> getProductsMatchingSearch(String searchString);

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
