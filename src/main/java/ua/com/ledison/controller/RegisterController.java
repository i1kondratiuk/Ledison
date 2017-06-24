package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.CartService;
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
	private CartService cartService;

	@Autowired
	private ShippingAddressService shippingAddressService;

	@PostMapping("/addUser")
	@ResponseBody
	public AjaxResponseBody addUser(@RequestBody User user) {
		AjaxResponseBody result = new AjaxResponseBody();
		List<User> users = userService.getAllUsers();
		if (user.getUsername().length() < 3 || user.getPassword().length() < 3) {
			result.setMsg("The fields must not be empty or less than 3 characters");
			result.setCode("400");
			result.setResult(user);

			return result;
		}
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
		if (principal == null) {
			model.addAttribute("user", new User());

			return "registerCustomer";
		}

		User user = userService.findByName(principal.getName());
		model.addAttribute("user", user);

		return "registerCustomer";
	}

	@PostMapping("/registerCustomer")
	public String registerCustomerPost(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return "registerCustomer";
		}

		if (principal == null) {
			User customer = userDTO.convertToUser();

			ShippingAddress shippingAddress = customer.getShippingAddress();
			shippingAddressService.addShippingAddress(shippingAddress);

			customer.setShippingAddress(shippingAddress);
			userService.addCustomer(customer);

			Cart cart = CartDTO.getInstance().convertCartDTOToCart();
			cart.setUser(customer);
			cartService.addCart(cart);
			customer.setCart(cart);

			shippingAddress.setUser(customer);
			shippingAddressService.updateShippingAddress(shippingAddress);
			userService.updateUser(customer);

			return "registerCustomerSuccess";
		}

		User existingUser = userService.findByName(principal.getName());

		ShippingAddress shippingAddress = userDTO.getShippingAddress();
		shippingAddress.setUser(existingUser);
		shippingAddressService.addShippingAddress(shippingAddress);

		existingUser.setFirstName(userDTO.getFirstName());
		existingUser.setLastName(userDTO.getLastName());
		existingUser.setEmail(userDTO.getEmail());
		existingUser.setPhone(userDTO.getPhone());
		existingUser.setShippingAddress(userDTO.getShippingAddress());
		existingUser.setEnabled(true);
		userService.updateUser(existingUser);

		return "registerCustomerSuccess";
	}
}