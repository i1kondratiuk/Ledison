package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.CustomerOrderService;
import ua.com.ledison.service.UserService;

import java.security.Principal;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/order")
    public String createOrder(Principal principal) {
        User user = userService.findByName(principal.getName());
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = user.getCart();
        customerOrder.setCart(cart);
        customerOrder.setUser(user);
        customerOrder.setShippingAddress(user.getShippingAddress());
        user.setOrder(customerOrder);
        customerOrderService.addCustomerOrder(customerOrder);
        userService.updateUser(user);

        return "thankCustomer";
    }
}