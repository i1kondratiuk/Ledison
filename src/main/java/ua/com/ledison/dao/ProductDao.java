package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.entity.Product;

import java.util.List;

public interface ProductDao extends JpaRepository<Product, Integer>, JpaSpecificationExecutor<Product> {

	@Transactional
	@Query("from Product p where p.recommended =:recommended")
	public List<Product> findRecommended(@Param("recommended") Boolean recommended);

}