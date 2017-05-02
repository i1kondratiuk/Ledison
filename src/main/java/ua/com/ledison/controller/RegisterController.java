package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.ShippingAddress;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.ShippingAddressService;
import ua.com.ledison.service.UserService;

@RestController
public class RegisterController {

    @Autowired
    private UserService userService;

    @Autowired
    private ShippingAddressService shippingAddressService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PostMapping("/addCustomerInfo")
    public User addCustomerInfo(@RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PostMapping("/addShippingAddress")
    public ShippingAddress addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        shippingAddressService.addShippingAddress(shippingAddress);
        return shippingAddress;
    }
}