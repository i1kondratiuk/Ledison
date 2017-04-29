package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.ProductManufacturer;

public interface ProductManufacturerDao extends JpaRepository<ProductManufacturer, Integer> {

}
