package ua.com.ledison.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/admin/product")
public class AdminProduct {

	@Autowired
	private ProductService productService;

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		product.setProductName("Lamp-1");
		product.setProductManufacturer("LG");
		product.setProductPrice(20.1);
		product.setProductCategory("ledBulbs");
		product.setCapType("E27");
		product.setGlowColor("neutralWhite");
		product.setLampShape("A60");
		product.setPower(3);
		product.setOperatingVoltage("220");
		product.setDiffuserType("frosted");
		product.setServiceLife(1200);
		product.setWarrantyPeriod(36);
		product.setUnitInStock(10);
		model.addAttribute("product", product);

		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result) throws IOException {

		if (result.hasErrors()) {
			return "addProduct";
		}

		productService.addProduct(product);

		MultipartFile multipartFile = product.getProductImage();

		String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator + product.getProductId() + ".jpg";

		if (multipartFile != null && !multipartFile.isEmpty()) {
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

	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "editProduct";
	}

	//	@PostMapping("/editProduct")
	//	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {
	//
	//		if (result.hasErrors()) {
	//			return "editProduct";
	//		}
	//
	//		MultipartFile productImage = product.getProductImage();
	//		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
	//		String path = rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png";
	//
	//		if (productImage != null && !productImage.isEmpty()) {
	//			try {
	//				productImage.transferTo(new File(path));
	//			} catch (Exception ex) {
	//				ex.printStackTrace();
	//				throw new RuntimeException("Product image saving failed", ex);
	//			}
	//		}
	//
	//		productService.editProduct(product);
	//
	//		return "redirect:/admin/productInventory";
	//	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model) {
		//		String path = rootDirectory + "/WEB-INF/resources/images/" + id + ".png";

		//!!!

		Product product = productService.getProductById(id);
		productService.deleteProduct(product);

		return "redirect:/admin/productInventory";
	}
}
