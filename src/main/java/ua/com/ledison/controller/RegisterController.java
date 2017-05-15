package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.ShippingAddress;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.ShippingAddressService;
import ua.com.ledison.service.UserService;
import ua.com.ledison.util.AjaxResponseBody;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;

	@Autowired
	private ShippingAddressService shippingAddressService;

	@PostMapping("/addUser")
	@ResponseBody
	public AjaxResponseBody addUser(@RequestBody User user) {
		AjaxResponseBody result = new AjaxResponseBody();
		List<User> users = userService.getAllUsers();
		for (int i = 0; i < users.size(); i++) {
			if (user.getUsername().equals(users.get(i).getUsername())) {
				result.setMsg("Username already exists");
				result.setCode("400");
				result.setResult(user);

				return result;
			}
		}
		result.setMsg("");
		result.setCode("200");
		result.setResult(user);
		userService.addUser(user);

		return result;
	}

	@GetMapping("/customer/profile")
	public String toUserProfile(Principal principal, Model model) {
		User user = userService.findByNameAndFetchOrders(principal.getName());
		List<CustomerOrder> customerOrders = user.getOrders();
		model.addAttribute("user", user);
		model.addAttribute("customerOrders", customerOrders);

		return "userProfile";
	}

	@GetMapping("/registerCustomer")
	public String toRegisterCustomer(Principal principal, Model model) {
		User user = userService.findByName(principal.getName());
		model.addAttribute("user", user);

		return "registerCustomer";
	}

	@PostMapping("/registerCustomer")
	public String registerCustomerPost(@Valid @ModelAttribute("user") User user, BindingResult result, Principal principal, Model model) {

		if (result.hasErrors()) {
			return "registerCustomer";
		}

		User existingUser = userService.findByName(principal.getName());

		List<User> users = userService.getAllUsers();

		for (int i = 0; i < users.size(); i++) {
			//            if(user.getUsername().equals(users.get(i).getUsername())){
			//                model.addAttribute("usernameMsg", "Username already exists");
			//
			//                return "registerCustomer";
			//            }
		}
		ShippingAddress shippingAddress = user.getShippingAddress();
		shippingAddress.setUser(existingUser);
		shippingAddressService.addShippingAddress(shippingAddress);

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		existingUser.setPhone(user.getPhone());
		existingUser.setShippingAddress(user.getShippingAddress());
		existingUser.setEnabled(true);
		userService.updateUser(existingUser);
		return "registerCustomerSuccess";
	}
}