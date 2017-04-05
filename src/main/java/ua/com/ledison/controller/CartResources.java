package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Cart;
import ua.com.ledison.entity.CartItem;
import ua.com.ledison.entity.Customer;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.CartItemService;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.CustomerService;
import ua.com.ledison.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/rest/cart")
public class CartResources {

	@Autowired
	private CartService cartService;

	@Autowired
	private CartItemService cartItemService;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private ProductService productService;

	@GetMapping("/{cartId}")
	public Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@GetMapping("/add/{productId}")
	public void addItem(@PathVariable(value = "productId") int productId, User activeUser) {
		Customer customer = customerService.getCustomerByUsername(activeUser.getUsername());
		Cart cart = customer.getCart();
		Product product = productService.getProductById(productId);
		List<CartItem> cartItems = cart.getCartItems();

		for (int i = 0; i < cartItems.size(); i++) {
			if (product.getProductId() == cartItems.get(i).getProduct().getProductId()) {
				CartItem cartItem = cartItems.get(i);
				cartItem.setQuantity(cartItem.getQuantity() + 1);
				cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
				cartItemService.addCartItem(cartItem);

				return;
			}
		}

		CartItem cartItem = new CartItem();
		cartItem.setProduct(product);
		cartItem.setQuantity(1);
		cartItem.setTotalPrice(product.getProductPrice() * cartItem.getQuantity());
		cartItem.setCart(cart);
		cartItemService.addCartItem(cartItem);
	}

	@GetMapping("/remove/{productId}")
	public void removeItem(@PathVariable(value = "productId") int productId) {
		CartItem cartItem = cartItemService.getCartItemByProductId(productId);
		cartItemService.removeCartItem(cartItem);
	}

	@GetMapping("/{cartId}")
	public void clearCart(@PathVariable(value = "cartId") int cartId) {
		Cart cart = cartService.getCartById(cartId);
		cartItemService.removeAllCartItems(cart);
	}
}