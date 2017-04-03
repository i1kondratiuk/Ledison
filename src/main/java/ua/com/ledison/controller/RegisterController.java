package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.service.CustomerService;
import ua.com.ledison.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private UserService userService;

	@GetMapping("/register")
	public String registerUser() {
		return "registerUser";
	}

	@GetMapping("/registerCustomer")
	public String registerCustomer() {
		return "registerCustomer";
	}

}