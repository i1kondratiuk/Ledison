package ua.com.ledison.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import ua.com.ledison.entity.Product;

import java.util.List;

public interface ProductService {

    Page<Product> findPaginated(Specification<Product> spec, Integer pageNumber);

    Page<Product> findPaginated(Integer pageNumber);

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
