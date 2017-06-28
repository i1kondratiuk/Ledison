package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.WarrantyPeriod;
import ua.com.ledison.service.WarrantyPeriodService;
import ua.com.ledison.validator.WarrantyPeriodFormValidator;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/product/{productId}/warranty")
public class AdminWarrantyPeriod {

	@Autowired
	private WarrantyPeriodService warrantyPeriodService;

	@Autowired
	WarrantyPeriodFormValidator warrantyPeriodFormValidator;
	@InitBinder
	public void bind(WebDataBinder binder){
		binder.addValidators(warrantyPeriodFormValidator);
	}

	@GetMapping
	public String warrantyPeriod(@PathVariable("productId") int productId, Model model) {
		WarrantyPeriod warrantyPeriod = new WarrantyPeriod();
		model.addAttribute("warrantyPeriod", warrantyPeriod);
		model.addAttribute("productId", productId);

		return "addWarrantyPeriod";
	}

	@PostMapping
	public String addWarrantyPeriod(@ModelAttribute("warrantyPeriod") @Valid WarrantyPeriod warrantyPeriod,
	                                    @PathVariable("productId") int productId,
	                                    Model model,
	                                    BindingResult result) {

		if (result.hasErrors()) {
			return "addWarrantyPeriod";
		}
		warrantyPeriodService.addWarrantyPeriod(warrantyPeriod);

		return "redirect:/admin/product/editProduct/" + productId;
	}
}
