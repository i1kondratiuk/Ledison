package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.PowerService;
import ua.com.ledison.service.ProductManufacturerService;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.WarrantyPeriodService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/admin/product")
public class AdminProduct {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductManufacturerService productManufacturerService;
	@Autowired
	private PowerService powerService;
	@Autowired
	private WarrantyPeriodService warrantyPeriodService;

	@GetMapping("/addProduct")
	public String addProduct(Model model) {

		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();
		List<Power> powers = powerService.getPowerList();
		List<WarrantyPeriod> warrantyPeriods = warrantyPeriodService.getWarrantyPeriodList();
		Product product = new Product();

		product.setProductName("Lamp-1");
		product.setProductPrice(20.1);
		product.setProductCategory("ledBulbs");
		product.setCapType(CapType.E27.name());
		product.setGlowColor(GlowColor.NEUTRAL_WHITE.name());
		product.setLampShape(LampShape.A60.name());
		product.setDiffuserType(DiffuserType.FROSTED.name());
		product.setOperatingVoltage(220);
		product.setServiceLife(1200);
		product.setUnitsInStock(10);

		model.addAttribute("product", product);
		model.addAttribute("productManufacturers", productManufacturers);
		model.addAttribute("powers", powers);
		model.addAttribute("capTypes", CapType.values());
		model.addAttribute("glowColors", GlowColor.values());
		model.addAttribute("lampShapes", LampShape.values());
		model.addAttribute("diffuserType", DiffuserType.values());
		model.addAttribute("warrantyPeriods", warrantyPeriods);

		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String addProductPost(@Valid @ModelAttribute("product") Product product, HttpServletRequest request, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "addProduct";
		}

		product.setProductManufacturer(productManufacturerService.getProductManufacturerById(Integer.parseInt(request.getParameter("productManufacturerId"))));
		product.setPower(powerService.getPowerById(Integer.parseInt(request.getParameter("powerId"))));
		productService.addProduct(product);

		MultipartFile multipartFile = product.getProductImage();

		String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator + product.getProductId() + ".jpg";

		if (multipartFile == null || multipartFile.isEmpty()) {
		} else {
			try {
				multipartFile.transferTo(new File(homePath));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Product image saving failed", e);
			}
		}

		productService.addProduct(product);

		return "redirect:/admin/productInventory";
	}

	@GetMapping("/addProductManufacturer")
	public String addProductManufacturer(Model model) {
		ProductManufacturer productManufacturer = new ProductManufacturer();
		model.addAttribute("productManufacturer", productManufacturer);

		return "addProductManufacturer";
	}

	@PostMapping("/addProductManufacturer")
	public String addProductManufacturerPost(@Valid @ModelAttribute("productManufacturer") ProductManufacturer productManufacturer, BindingResult result) {

		if (result.hasErrors()) {
			return "addProductManufacturer";
		}
		productManufacturerService.addProductManufacturer(productManufacturer);

		return "redirect:/admin/product/addProduct";
	}

	@GetMapping("/addPower")
	public String addPower(Model model) {
		Power power = new Power();
		model.addAttribute("power", power);

		return "addPower";
	}

	@PostMapping("/addPower")
	public String addPowerPost(@Valid @ModelAttribute("power") Power power, BindingResult result) {

		if (result.hasErrors()) {
			return "addPower";
		}
		powerService.addPower(power);

		return "redirect:/admin/product/addProduct";
	}

	@GetMapping("/addWarrantyPeriod")
	public String addWarrantyPeriod(Model model) {
		WarrantyPeriod warrantyPeriod = new WarrantyPeriod();
		model.addAttribute("warrantyPeriod", warrantyPeriod);

		return "addWarrantyPeriod";
	}

	@PostMapping("/addWarrantyPeriod")
	public String addWarrantyPeriodPost(@Valid @ModelAttribute("warrantyPeriod") WarrantyPeriod warrantyPeriod, BindingResult result) {

		if (result.hasErrors()) {
			return "addWarrantyPeriod";
		}
		warrantyPeriodService.addWarrantyPeriod(warrantyPeriod);

		return "redirect:/admin/product/addProduct";
	}

	@GetMapping("/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProductById(productId);
		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();
		List<Power> powers = powerService.getPowerList();
		List<WarrantyPeriod> warrantyPeriods = warrantyPeriodService.getWarrantyPeriodList();

		model.addAttribute("product", product);
		model.addAttribute("productManufacturers", productManufacturers);
		model.addAttribute("powers", powers);
		model.addAttribute("glowColors", GlowColor.values());
		model.addAttribute("capTypes", CapType.values());
		model.addAttribute("lampShapes", LampShape.values());
		model.addAttribute("diffuserType", DiffuserType.values());
		model.addAttribute("warrantyPeriods", warrantyPeriods);


		return "editProduct";
	}

	@PostMapping("/editProduct")
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		product.setProductManufacturer(productManufacturerService.getProductManufacturerById(Integer.parseInt(request.getParameter("productManufacturerId"))));
		product.setPower(powerService.getPowerById(Integer.parseInt(request.getParameter("powerId"))));
		product.setWarrantyPeriod(warrantyPeriodService.getWarrantyPeriodById(Integer.parseInt(request.getParameter("warrantyPeriodId"))));
		productService.addProduct(product);

		MultipartFile multipartFile = product.getProductImage();

		String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator + product.getProductId() + ".jpg";

		if (!product.getProductImage().isEmpty()) {
			File file = new File(homePath);
			file.delete();
		}

		if (multipartFile == null || multipartFile.isEmpty()) {
		} else try {
			multipartFile.transferTo(new File(homePath));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Product image saving failed", e);
		}

		productService.editProduct(product);

		return "redirect:/admin/productInventory";
	}

	@GetMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		Product product = productService.getProductById(productId);
		productService.deleteProduct(product);

		String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator + product.getProductId() + ".jpg";
		File file = new File(homePath);
		file.delete();

		return "redirect:/admin/productInventory";
	}
}
