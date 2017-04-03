package ua.com.ledison.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.CartItemDao;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.service.CartItemService;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {

    }

    public void removeCartItem(CartItem cartItem) {

    }

    public void removeAllCartItems(Cart cart) {

    }

    public CartItem getCartItemByProductId(int productId) {
        return null;
    }
}