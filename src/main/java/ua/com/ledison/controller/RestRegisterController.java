package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.entity.ShippingAddress;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CustomerService;
import ua.com.ledison.service.ShippingAddressService;
import ua.com.ledison.service.UserService;

@RestController
public class RestRegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @PostMapping("/createUser")
    public User createUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PostMapping("/createCustomer")
    public Customer createCustomer(@RequestBody Customer customer) {
        customerService.addCustomer(customer);
        return customer;
    }

    @PostMapping("/createShippingAddress")
    public ShippingAddress createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        shippingAddressService.addShippingAddress(shippingAddress);
        return shippingAddress;
    }
}
