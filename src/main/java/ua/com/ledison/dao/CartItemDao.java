package ua.com.ledison.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.ledison.entity.CartItem;

public interface CartItemDao extends JpaRepository<CartItem,Integer> {
}
