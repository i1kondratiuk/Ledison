package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.CartItemDao;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.service.CartItemService;

import java.util.List;

@Service
public class CartItemServiceImpl implements CartItemService {

    @Autowired
    private CartItemDao cartItemDao;

    public void addCartItem(CartItem cartItem) {
        cartItemDao.save(cartItem);
    }

    public void deleteCartItem(CartItem cartItem) {
        cartItemDao.delete(cartItem.getCartItemId());
    }

    public void deleteAllCartItems(List<CartItem> cartItems){
        for (CartItem cartItem : cartItems){
            deleteCartItem(cartItem);
        }
    }

    public CartItem getCartItemById(int cartItemId) {
        return cartItemDao.findOne(cartItemId);
    }
}