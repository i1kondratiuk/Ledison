package ua.com.ledison.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.ledison.dao.CustomerOrderDao;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.CustomerOrderService;

import java.util.List;

@Service
@Transactional
public class CustmerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDao customerOrderDao;

    @Autowired
    private CartService cartService;

    @Override
    public List<CustomerOrder> getAllOrders() {
        return customerOrderDao.findAll();
    }

    public void addCustomerOrder(CustomerOrder customerOrder){
        customerOrderDao.save(customerOrder);
    }

    public double getCustomerOrderGrandTotal(int cartId){
        double grandTotal = 0;
        Cart cart = cartService.getCartById(cartId);
        List<CartItem> cartItems = cart.getCartItems();

        for (CartItem item : cartItems){
            grandTotal += item.getTotalPrice();
        }
        return grandTotal;
    }

}
