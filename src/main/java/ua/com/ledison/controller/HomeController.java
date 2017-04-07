package ua.com.ledison.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/home"})
    public String home() {
        return "home";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }


    //???
    @GetMapping("/registerUser")
    public String registerUser() {
        return "registerUser";
    }

    @GetMapping("/collectCustomerInfo")
    public String collectCustomerInfo() {
        return "collectCustomerInfo";
    }

}