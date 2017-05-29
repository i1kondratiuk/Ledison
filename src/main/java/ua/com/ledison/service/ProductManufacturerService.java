package ua.com.ledison.service;

import ua.com.ledison.entity.ProductManufacturer;

import java.util.List;

public interface ProductManufacturerService {

	List<ProductManufacturer> getProductManufacturerList();
	ProductManufacturer getProductManufacturerById(int id);
	void addProductManufacturer(ProductManufacturer productManufacturer);
	void editProductManufacturer(ProductManufacturer productManufacturer);
	void deleteProductManufacturer(ProductManufacturer productManufacturer);
}
