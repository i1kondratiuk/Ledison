package ua.com.ledison.service;


import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;

public interface CartItemService {

    void addCartItem(CartItem cartItem);

    void removeCartItem(CartItem cartItem);

    void removeAllCartItems(Cart cart);

    CartItem getCartItemByProductId(int productId);

}
