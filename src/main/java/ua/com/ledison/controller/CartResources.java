package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.User;
import ua.com.ledison.service.CartItemService;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.UserService;

import java.security.Principal;
import java.util.List;

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

	@GetMapping("/{cartId}")
	public Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@GetMapping("/add/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItem(@PathVariable(value = "productId") int productId, Principal principal) {
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

	public static double roundDoubleValue(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}

	@GetMapping("/remove/{productId}")
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.deleteCartItem(cartItem);
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