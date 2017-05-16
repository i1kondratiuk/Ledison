package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.OrderStatus;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.CustomerOrderService;
import ua.com.ledison.service.UserService;

import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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
        User user = userService.findByNameAndFetchOrders(principal.getName());
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = user.getCart();
        customerOrder.setCart(cart);
        customerOrder.setUser(user);
        customerOrder.setShippingAddress(user.getShippingAddress());

        Date now = new Date();
        DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
        DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
        String nowTime = formatterTime.format(now);
        String nowDate = formatterDate.format(now);
        customerOrder.setOrderTime(nowTime);
        customerOrder.setOrderDate(nowDate);

        customerOrder.setStatus(OrderStatus.AWAITING_PAYMENT);

        user.getOrders().add(customerOrder);
        user.setCart(null);
        customerOrderService.addCustomerOrder(customerOrder);
        userService.updateUser(user);

        return "thankCustomer";
    }
}