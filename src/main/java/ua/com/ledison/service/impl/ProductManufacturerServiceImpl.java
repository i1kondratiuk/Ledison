package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.ProductManufacturerDao;
import ua.com.ledison.entity.ProductManufacturer;
import ua.com.ledison.service.ProductManufacturerService;

import java.util.List;

@Service
@Transactional
public class ProductManufacturerServiceImpl implements ProductManufacturerService {

	@Autowired
	private ProductManufacturerDao productManufacturerDao;

	@Override
	public List<ProductManufacturer> getProductManufacturerList() {
		return productManufacturerDao.findAll();
	}

	@Override
	public ProductManufacturer getProductManufacturerById(int id) {
		return productManufacturerDao.findOne(id);
	}

	@Override
	public void addProductManufacturer(ProductManufacturer productManufacturer) {
		productManufacturerDao.save(productManufacturer);
	}

	@Override
	public void editProductManufacturer(ProductManufacturer productManufacturer) {
		productManufacturerDao.save(productManufacturer);
	}

	@Override
	public void deleteProductManufacturer(ProductManufacturer productManufacturer) {
		productManufacturerDao.delete(productManufacturer);
	}
}
