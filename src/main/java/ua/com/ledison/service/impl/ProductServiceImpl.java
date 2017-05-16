package ua.com.ledison.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.ProductDao;
import ua.com.ledison.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.service.ProductService;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final int PAGE_SIZE = 9;

	@Autowired
	private ProductDao productDao;

	public Product getProductById(int productId) {
		return productDao.findOne(productId);
	}

	@Override
	public Page<Product> findPaginated(Specification<Product> spec, Integer pageNumber) {
		Page requestedPage = productDao.findAll(spec,
				new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "productId"));
		if (requestedPage.getTotalPages() == 0) {
			return null;
		}
		return requestedPage;
	}

	@Override
	public List<Product> findProductsByName(String productName) {
		return productDao.findAll();
	}

	public List<Product> getProductList() {
		return productDao.findAll();
	}

	public void addProduct(Product product) {
		productDao.save(product);
	}

	public void editProduct(Product product) {
		productDao.save(product);
	}

	public void deleteProduct(Product product) {
		productDao.delete(product.getProductId());
	}
}