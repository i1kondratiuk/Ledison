package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.CustomerOrderService;

@Controller
public class OrderController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @GetMapping("/order/{cartId}")
    public String createOrder(@PathVariable("cartId") int cartId){
        CustomerOrder customerOrder = new CustomerOrder();
        Cart cart = cartService.getCartById(cartId);
        customerOrder.setCart(cart);

        Customer customer = cart.getCustomer();
        customerOrder.setCustomer(customer);
        customer.setShippingAddress(customer.getShippingAddress());

        customerOrderService.addCustomerOrder(customerOrder);

        return "redirect:/thankCustomer";

    }

}