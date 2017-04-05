package ua.com.ledison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("home")
	public String toHome() {
		return "home";
	}

	@GetMapping("login")
	public String toLogin() {
		return "login";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}
}