package ua.com.ledison.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import ua.com.ledison.dao.ProductDao;
import ua.com.ledison.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    public Product getProductById(int productId){
        return productDao.findOne(productId);
    }

    @Override
    public Page<Product> findPaginated(int page, int size) {
        return productDao.findAll(new PageRequest(page, size));
    }

    public List<Product> getProductList(){
        return productDao.findAll();
    }

    public void addProduct(Product product){
        productDao.save(product);
    }

    public void editProduct(Product product){
        productDao.save(product);
    }

    public void deleteProduct(Product product){
        productDao.delete(product);
    }

}
