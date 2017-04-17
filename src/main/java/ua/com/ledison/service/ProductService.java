package ua.com.ledison.service;


import org.springframework.data.domain.Page;
import ua.com.ledison.entity.Product;

import java.util.List;

public interface ProductService {

    Page<Product> findPaginated(int pageNumber);

    List<Product> getProductList();

    Product getProductById(int id);

    void addProduct(Product product);

    void editProduct(Product product);

    void deleteProduct(Product product);

}
