package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.ledison.dao.CartDao;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.service.CartService;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartDao cartDao;

    public Cart getCartById(int cartId) {
        return cartDao.findOne(cartId);
    }

    public void update(Cart cart){
        cartDao.save(cart);
    }

}