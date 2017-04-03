package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("home")
	public String toHome() {
		return "home";
	}

	@PostMapping("save")
	public String save(@RequestParam("username") String username, @RequestParam("password") String password) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		userService.addUser(user);
		return "index";
	}

	@GetMapping("login")
	public String toLogin() {
		return "login";
	}

	//    @RequestMapping("/login")
	//    public String login(
	//            @RequestParam(value="error", required = false)
	//            String error,
	//            @RequestParam(value="logout", required = false)
	//            String logout,
	//            Model model){
	//
	//        if(error != null){
	//            model.addAttribute("error", "Invalid username and password");
	//        }
	//
	//        if (logout !=null){
	//            model.addAttribute("msg", "You have been logged out successfully");
	//        }
	//        return "login";
	//    }
	//
	//    @RequestMapping("/about")
	//    public String about(){
	//        return "about";
	//    }
}