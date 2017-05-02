package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @GetMapping
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);

        return "productInventory";
    }

    @GetMapping("/customer")
    public String customerManagement(Model model){
        List<User> customerList = userService.getAllUsers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

}