package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.CustomerOrderService;
import ua.com.ledison.service.MailService;
import ua.com.ledison.service.SoldUnitService;
import ua.com.ledison.service.UserService;
import ua.com.ledison.util.CookieManager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static ua.com.ledison.util.Math.roundDoubleValue;

@Controller
public class OrderController {

	@Autowired
	private SoldUnitService soldUnitService;

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@Autowired
	MailService mailService;

	@Transactional
	@GetMapping("/order")
	public String createOrder(Principal principal, HttpServletResponse response) {
		User user;
		boolean isCartEmpty = false;

		if (principal == null) {
			user = userService.findById(CartDTO.getInstance().getUserId());
			CartDTO.setInstance(null);
			Cookie cookie = new Cookie("cart", null);
			cookie.setPath("/");
			cookie.setMaxAge(0);
			response.addCookie(cookie);
			CartDTO.setInstance(CookieManager.convertCookieToCartDTO(null));
		} else {
			user = userService.findByNameAndFetchOrders(principal.getName());
			isCartEmpty = true;
		}

		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = user.getCart();
		customerOrder.setCart(cart);
		customerOrder.setUser(user);
		customerOrder.setShippingAddress(user.getShippingAddress());

		boolean isCurrentItemUpdated = false;
		for (CartItem cartItem : cart.getCartItems()) {
			for (SoldUnit soldUnit : soldUnitService.getSoldUnitsList()) {
				if (soldUnit.getProduct().getProductId() == cartItem.getProduct().getProductId()) {
					soldUnit.setQuantity(soldUnit.getQuantity() + cartItem.getQuantity());
					soldUnit.setTotalPrice(roundDoubleValue(soldUnit.getTotalPrice() + cartItem.getTotalPrice(), 2));
					soldUnitService.update(soldUnit);
					isCurrentItemUpdated = true;
					break;
				}
			}
			if (!isCurrentItemUpdated) {
				soldUnitService.update(new SoldUnit(cartItem.getProduct(), cartItem.getQuantity(), cartItem.getTotalPrice()));
			}
			isCurrentItemUpdated = false;
		}

		Date now = new Date();
		DateFormat formatterTime = new SimpleDateFormat("HH:mm:ss");
		DateFormat formatterDate = new SimpleDateFormat("yyyy-MM-dd");
		String nowTime = formatterTime.format(now);
		String nowDate = formatterDate.format(now);
		customerOrder.setOrderTime(nowTime);
		customerOrder.setOrderDate(nowDate);

		customerOrder.setStatus(OrderStatus.AWAITING_PAYMENT);

		user.getOrders().add(customerOrder);
		if (isCartEmpty) {
			user.setCart(null);
		}
		customerOrderService.addCustomerOrder(customerOrder);
		userService.updateUser(user);

		mailService.sendMail(user);

		return "thankCustomer";
	}
}