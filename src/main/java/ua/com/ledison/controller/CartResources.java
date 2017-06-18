package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.CartItemService;
import ua.com.ledison.service.CartService;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.UserService;
import ua.com.ledison.util.CookieManager;

import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
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
	public String addCartToCookie(HttpServletResponse response) {
		CartDTO cartDTO = CartDTO.getInstance();
		response.addCookie(CookieManager.saveCartToCookie("cart", cartDTO, 24 * 60 * 60));

		return "redirect:/rest/cart/cartCookie";
	}

	@GetMapping("/cartCookie")
	public String getCartWithCookie(@CookieValue(value = "cart") String cartCookie, Model model) {
		System.out.println(cartCookie);
		model.addAttribute("cart", CookieManager.convertCookieToCartDTO(cartCookie));

		return "cart";
	}

	@GetMapping("/add/{productId}")
	public String addItem(@PathVariable(value = "productId") int productId, Principal principal) {
		if (principal == null) {
			return "redirect:/rest/cart/addToCookie/" + productId;
		} else
			return "redirect:/rest/cart/addToCart/" + productId;
	}

	@GetMapping("/addToCookie/{productId}")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItemToUnregisteredCustomerCart(@PathVariable(value = "productId") int productId) {
		CartDTO cartDTO = CartDTO.getInstance();
		Product product = productService.getProductById(productId);
		List<CartItemDTO> cartItemsDTO;
		if (cartDTO.getCartItemsDTO() == null) {
			cartItemsDTO = new ArrayList<>();
		} else {
			cartItemsDTO = cartDTO.getCartItemsDTO();
		}

		for (int i = 0; i < cartItemsDTO.size(); i++) {
			if (productId == cartItemsDTO.get(i).getProductId()) {
				CartItemDTO cartItemDTO = cartItemsDTO.get(i);
				cartItemDTO.setQuantity(cartItemDTO.getQuantity() + 1);
				cartItemDTO.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItemDTO.getQuantity(), 2));
				Double grandTotalRounded = roundDoubleValue(cartDTO.getGrandTotal() + product.getProductPrice(), 2);
				cartDTO.setGrandTotal(grandTotalRounded);

				return;
			}
		}

		CartItemDTO cartItemDTO = new CartItemDTO();
		cartItemDTO.setProductId(productId);
		cartItemDTO.setQuantity(1);
		cartItemDTO.setTotalPrice(roundDoubleValue(product.getProductPrice() * cartItemDTO.getQuantity(), 2));
		Double grandTotalRounded = roundDoubleValue(cartDTO.getGrandTotal() + product.getProductPrice(), 2);
		cartDTO.setGrandTotal(grandTotalRounded);
		cartItemsDTO.add(cartItemDTO);
		cartDTO.setCartItemsDTO(cartItemsDTO);
	}

	@GetMapping("/{cartId}")
	public Cart getCartById(@PathVariable(value = "cartId") int cartId) {
		return cartService.getCartById(cartId);
	}

	@GetMapping("/addToCart/{productId}")
	@Transactional
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addItemToCustomerCart(@PathVariable(value = "productId") int productId, Principal principal) {
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