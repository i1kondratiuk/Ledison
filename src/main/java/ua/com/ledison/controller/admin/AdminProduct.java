package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.ledison.entity.CapType;
import ua.com.ledison.entity.Product;
import ua.com.ledison.entity.ProductManufacturer;
import ua.com.ledison.service.ProductManufacturerService;
import ua.com.ledison.service.ProductService;

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

	@GetMapping("/addProduct")
	public String addProduct(Model model) {

		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();
		Product product = new Product();

		product.setProductManufacturer(productManufacturerService.getProductManufacturerById(3));
		product.setProductName("Lamp-1");
		product.setProductPrice(20.1);
		product.setProductCategory("ledBulbs");
		product.setCapType(CapType.E27.toString());
		product.setGlowColor("neutralWhite");
		product.setLampShape("A60");
		product.setPower(3);
		product.setOperatingVoltage("220");
		product.setDiffuserType("frosted");
		product.setServiceLife(1200);
		product.setWarrantyPeriod(36);
		product.setUnitInStock(10);

		model.addAttribute("product", product);
		model.addAttribute("productManufacturers", productManufacturers);
		model.addAttribute("capTypes", CapType.values());

		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String addProductPost(@Valid @ModelAttribute("product") Product product, HttpServletRequest request, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "addProduct";
		}

		product.setProductManufacturer(productManufacturerService.getProductManufacturerById(Integer.parseInt(request.getParameter("productManufacturerId"))));
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

	@GetMapping("/editProduct/{productId}")
	public String editProduct(@PathVariable("productId") int productId, Model model) {
		Product product = productService.getProductById(productId);
		List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();

		model.addAttribute("product", product);
		model.addAttribute("productManufacturers", productManufacturers);

		return "editProduct";
	}

	@PostMapping("/editProduct")
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		product.setProductManufacturer(productManufacturerService.getProductManufacturerById(Integer.parseInt(request.getParameter("productManufacturerId"))));
		productService.addProduct(product);

		MultipartFile multipartFile = product.getProductImage();

		String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator + product.getProductId() + ".jpg";

		File file = new File(homePath);
		file.delete();

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
