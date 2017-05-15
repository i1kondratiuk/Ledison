package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.service.CustomerOrderService;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrder {

	@Autowired
	CustomerOrderService customerOrderService;

	@GetMapping
	public String customerManagement(Model model) {
		List<CustomerOrder> customerOrders = customerOrderService.getAllOrders();
		model.addAttribute("customerOrders", customerOrders);

		return "orderManagement";
	}
}
