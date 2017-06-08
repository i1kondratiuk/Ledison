package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.CustomerOrderService;
import ua.com.ledison.service.SoldUnitService;
import ua.com.ledison.service.UserService;

import javax.transaction.Transactional;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class OrderController {

	@Autowired
	private SoldUnitService soldUnitService;

	@Autowired
	private UserService userService;

	@Autowired
	private CustomerOrderService customerOrderService;

	@Transactional
	@GetMapping("/order")
	public String createOrder(Principal principal) {
		User user = userService.findByNameAndFetchOrders(principal.getName());
		CustomerOrder customerOrder = new CustomerOrder();
		Cart cart = user.getCart();
		customerOrder.setCart(cart);
		customerOrder.setUser(user);
		customerOrder.setShippingAddress(user.getShippingAddress());

		for (CartItem cartItem : cart.getCartItems()) {
			for (SoldUnit soldUnit : soldUnitService.getSoldUnitsList()) {
				if (soldUnit.getProduct().getProductId() == cartItem.getProduct().getProductId()) {
					soldUnit.setQuantity(soldUnit.getQuantity() + cartItem.getQuantity());
					soldUnit.setTotalPrice(soldUnit.getTotalPrice() + cartItem.getTotalPrice());
					soldUnitService.update(soldUnit);
					break;
				}
			}
			soldUnitService.update(new SoldUnit(cartItem.getProduct(), cartItem.getQuantity(), cartItem.getTotalPrice()));
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
		user.setCart(null);
		customerOrderService.addCustomerOrder(customerOrder);
		userService.updateUser(user);

		return "thankCustomer";
	}
}