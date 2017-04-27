package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.Cart;

public interface CartDao extends JpaRepository<Cart, Integer> {

}