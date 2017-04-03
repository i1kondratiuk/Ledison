package ua.com.ledison.service;

import ua.com.ledison.entity.Cart;

public interface CartService {

    Cart getCartById(int cartId);

    void update(Cart cart);
}
