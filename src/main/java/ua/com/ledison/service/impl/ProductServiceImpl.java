package ua.com.ledison.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.ProductDao;
import ua.com.ledison.dao.SoldUnitDao;
import ua.com.ledison.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.service.ProductService;

import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	private static final int PAGE_SIZE = 9;

	@Autowired
	private ProductDao productDao;

	@Autowired
	private SoldUnitDao soldUnitDao;

	public Product getProductById(int productId) {
		return productDao.findOne(productId);
	}

	public Product getProductByIdAndFetchLazyCartItemList(int productId) {
		Product product = productDao.findOne(productId);
		product.fetchLazyCollection();
		return product;
	}

	public Page<Product> findPaginated(Specification<Product> spec, Integer pageNumber) {
		Page requestedPage = productDao.findAll(spec,
				new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "productId"));
		if (requestedPage.getTotalPages() == 0) {
			return null;
		}
		return requestedPage;
	}

	public List<Product> getProductsMatchingSearch(String searchString) {
		List<Product> result = new LinkedList<>();
		for (Product product : getProductList()) {
			if (product.getProductName().toLowerCase().startsWith(searchString.toLowerCase())) {
				result.add(product);
			}
		}
		return result;
	}

	public List<Product> getProductList() {
		return productDao.findAll();
	}

	@Transactional
	public List<Product> getRecommendedProductList() {
		List<Product> products = productDao.findRecommended(true);
		return products;
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