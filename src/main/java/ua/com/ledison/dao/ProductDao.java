package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {
}
