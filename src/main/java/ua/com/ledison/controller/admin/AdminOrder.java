package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.com.ledison.entity.CustomerOrder;
import ua.com.ledison.entity.OrderStatus;
import ua.com.ledison.service.CustomerOrderService;
import ua.com.ledison.service.MailService;

import java.util.List;

@Controller
@RequestMapping("/admin/orders")
public class AdminOrder {

	@Autowired
	CustomerOrderService customerOrderService;

	@Autowired
	MailService mailService;

	@GetMapping
	public String customerManagement(Model model) {
		List<CustomerOrder> customerOrders = customerOrderService.getAllOrders();
		model.addAttribute("customerOrders", customerOrders);
		model.addAttribute("orderStatuses", OrderStatus.values());

		return "orderManagement";
	}

	@GetMapping("/changeOrderStatus/{customerOrderId}/{customerOrderStatus}")
	public String changeOrderStatus(@PathVariable("customerOrderId") int customerOrderId,
	                                @PathVariable("customerOrderStatus") OrderStatus customerOrderStatus,
	                                Model model) {
		CustomerOrder customerOrder = customerOrderService.findCustomerOrderById(customerOrderId);
		customerOrder.setStatus(customerOrderStatus);
		customerOrderService.updateCustomerOrder(customerOrder);

		mailService.sendMailAboutOrderStatusChanging(customerOrder.getUser(), customerOrder);

		List<CustomerOrder> customerOrders = customerOrderService.getAllOrders();

		model.addAttribute("customerOrders", customerOrders);
		model.addAttribute("orderStatuses", OrderStatus.values());

		return "orderManagement";
	}
}
