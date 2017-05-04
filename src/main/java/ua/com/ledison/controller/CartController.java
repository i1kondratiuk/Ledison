package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/customer/cart")
public class CartController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String getCart(Principal principal, Model model) {
        User user = userService.findByName(principal.getName());
        if (user.getCart() == null) {
            user.setCart(new Cart());
        }

        int cartId = user.getCart().getCartId();

        model.addAttribute("cart", user.getCart());

        return "redirect:/customer/cart/" + cartId;
    }

    @GetMapping("/{cartId}")
    public String getCartRedirect(@PathVariable int cartId, Model model) {
        model.addAttribute("cartId", cartId);

        return "cart";
    }
}