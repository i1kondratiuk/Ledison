package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CartItemService;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ua.com.ledison.util.Math.roundDoubleValue;

@Controller
@RequestMapping("/rest/cart")
public class CartResources {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    UserService userService;

    @Autowired
    private ProductService productService;

    @GetMapping
    public Cart getCart(@CookieValue(value = "cart", defaultValue = "defaultCookieValue")
                                String cart) {
        System.out.println(cart);

        return new Cart();
    }

    @GetMapping("/{cartId}")
    public Cart getCartById(@PathVariable(value = "cartId") int cartId) {
        return cartService.getCartById(cartId);
    }

    @GetMapping("/add/{productId}")
    @Transactional
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void addItem(@PathVariable(value = "productId") int productId,
                        Principal principal, HttpServletRequest request,
                        HttpServletResponse response) {

        if (principal == null) {
            Cart cart = new Cart();
            Product product = productService.getProductById(productId);
            List<CartItem> cartItems;
            if (cart.getCartItems() == null) {
                cartItems = new ArrayList<>();
            } else {
                cartItems = cart.getCartItems();
            }

            for (int i = 0; i < cartItems.size(); i++) {
                if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                    CartItem cartItem = cartItems.get(i);
                    cartItem.setQuantity(cartItem.getQuantity() + 1);
                    cartItem.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItem.getQuantity(), 2));
                    Double grandTotalRounded = roundDoubleValue(cart.getGrandTotal() + cartItem.getProduct().getProductPrice(), 2);
                    cart.setGrandTotal(grandTotalRounded);

                    return;
                }
            }

            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(1);
            cartItem.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItem.getQuantity(), 2));
            cartItem.setCart(cart);
            Double grandTotalRounded = roundDoubleValue(cart.getGrandTotal() + cartItem.getProduct().getProductPrice(), 2);
            cart.setGrandTotal(grandTotalRounded);
            cartItems.add(cartItem);
            cart.setCartItems(cartItems);

            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                Arrays.stream(cookies)
                        .forEach(c -> System.out.println(c.getName() + "=" + c.getValue()));
            }

            Cookie newCookie = new Cookie("cart", Arrays.asList(cart.toString()).toString());
            newCookie.setMaxAge(24 * 60 * 60);
            response.addCookie(newCookie);

            return;
        }

        User user = userService.findByNameAndFetchItems(principal.getName());

        Cart cart = user.getCart();
        Product product = productService.getProductById(productId);
        List<CartItem> cartItems = cart.getCartItems();

        for (int i = 0; i < cartItems.size(); i++) {
            if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
                CartItem cartItem = cartItems.get(i);
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItem.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItem.getQuantity(), 2));
                cartItemService.addCartItem(cartItem);
                Double grandTotalRounded = roundDoubleValue(cart.getGrandTotal() + cartItem.getProduct().getProductPrice(), 2);
                cart.setGrandTotal(grandTotalRounded);
                cartService.update(cart);

                return;
            }
        }

        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(1);
        cartItem.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItem.getQuantity(), 2));
        cartItem.setCart(cart);
        cartItemService.addCartItem(cartItem);
        Double grandTotalRounded = roundDoubleValue(cart.getGrandTotal() + cartItem.getProduct().getProductPrice(), 2);
        cart.setGrandTotal(grandTotalRounded);
        cart.setCartItems(cartItems);
        cartService.update(cart);
    }

    @GetMapping("/remove/{cartItemId}")
    public String removeItem(@PathVariable(value = "cartItemId") int cartItemId) {
        CartItem cartItem = cartItemService.getCartItemById(cartItemId);
        Cart cart = cartItem.getCart();
        cart.setGrandTotal(roundDoubleValue(cartItem.getCart().getGrandTotal() - cartItem.getTotalPrice(), 2));
        cartService.update(cart);
        cartItem.getCart().getGrandTotal();
        cartItemService.deleteCartItem(cartItem);

        return "redirect:/customer/cart/";
    }

    @GetMapping("/removeAll")
    public String clearCart(Principal principal) {
        Cart cart = userService.findByNameAndFetchItems(principal.getName()).getCart();
        cart.setGrandTotal(0.0);
        cartService.update(cart);
        cartItemService.deleteAllCartItems(cart.getCartItems());

        return "redirect:/customer/cart/";
    }
}