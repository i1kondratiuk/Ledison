package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.service.CustomerService;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String getCart(User activeUser){
        Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
        int cartId = customer.getCart().getCartId();

        return "redirect:/customer/cart/" + cartId;
    }

    @GetMapping("/{cartId}")
    public String getCartRedirect(@PathVariable int cartId, Model model){
        model.addAttribute("cartId", cartId);

        return "cart";
    }

}