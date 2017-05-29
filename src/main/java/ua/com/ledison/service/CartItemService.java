package ua.com.ledison.service;

import ua.com.ledison.entity.CartItem;

import java.util.List;

public interface CartItemService {

    void addCartItem(CartItem cartItem);
    void deleteCartItem(CartItem cartItem);
    void deleteAllCartItems(List<CartItem> cartItems);
    CartItem getCartItemById(int cartItemId);
}
