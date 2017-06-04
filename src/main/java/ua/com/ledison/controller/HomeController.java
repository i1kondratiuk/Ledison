package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.ledison.service.ProductService;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping({"/", "/home"})
    @Transactional
    public String home(Model model) {
        model.addAttribute("recommendedProducts", productService.getRecommendedProductList());

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

    @GetMapping("/registerUser")
    public String registerUser() {
        return "registerUser";
    }

    @GetMapping("/collectCustomerInfo")
    public String collectCustomerInfo() {
        return "collectCustomerInfo";
    }

}