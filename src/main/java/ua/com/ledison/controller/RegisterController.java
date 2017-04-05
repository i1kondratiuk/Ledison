package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.entity.ShippingAddress;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CustomerService;
import ua.com.ledison.service.ShippingAddressService;
import ua.com.ledison.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ShippingAddressService shippingAddressService;

	@GetMapping("/registerUser")
	public String registerUser() {
		return "registerUser";
	}

	@GetMapping("/collectCustomerInfo")
	public String collectCustomerInfo() {
		return "collectCustomerInfo";
	}

	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		userService.addUser(user);
		return user;
	}

	@PostMapping("/addCustomerInfo")
	public Customer addCustomerInfo(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
		return customer;
	}

	@PostMapping("/addShippingAddress")
	public ShippingAddress addShippingAddress(@RequestBody ShippingAddress shippingAddress) {
		shippingAddressService.addShippingAddress(shippingAddress);
		return shippingAddress;
	}
}