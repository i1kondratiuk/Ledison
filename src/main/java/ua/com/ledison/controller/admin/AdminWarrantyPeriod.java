package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.WarrantyPeriod;
import ua.com.ledison.service.WarrantyPeriodService;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/product/warranty")
public class AdminWarrantyPeriod {

	@Autowired
	private WarrantyPeriodService warrantyPeriodService;

	@GetMapping
	public String warrantyPeriod(Model model) {
		WarrantyPeriod warrantyPeriod = new WarrantyPeriod();
		model.addAttribute("warrantyPeriod", warrantyPeriod);

		return "addWarrantyPeriod";
	}

	@PostMapping
	public String addWarrantyPeriod(@ModelAttribute("warrantyPeriod") @Valid WarrantyPeriod warrantyPeriod,
	                                    BindingResult result) {

		if (result.hasErrors()) {
			return "addWarrantyPeriod";
		}
		warrantyPeriodService.addWarrantyPeriod(warrantyPeriod);

		return "redirect:/admin/product/editProduct";
	}
}
