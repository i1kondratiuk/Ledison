package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.CustomerService;
import ua.com.ledison.service.ProductService;

import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminHome {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/productInventory")
    public String productInventory(Model model){
        List<Product> products = productService.getProductList();
        String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        model.addAttribute("products", products);
        model.addAttribute("homePath", homePath);

        return "productInventory";
    }

    @GetMapping("/customer")
    public String customerManagement(Model model){

        List<Customer> customerList = customerService.getAllCustomers();
        model.addAttribute("customerList", customerList);

        return "customerManagement";
    }

}