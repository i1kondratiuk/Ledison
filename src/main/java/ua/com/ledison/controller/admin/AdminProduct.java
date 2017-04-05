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

@Controller
@RequestMapping("/admin/product")
public class AdminProduct {

	@Autowired
	private ProductService productService;

	@GetMapping("/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "addProduct";
	}

	@PostMapping("/addProduct")
	public String addProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "addProduct";
		}

		productService.addProduct(product);

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String realPath = rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png";

		if (productImage != null && !productImage.isEmpty()) try {
			productImage.transferTo(new File(realPath));
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("Product image saving failed", ex);
		}

		return "redirect:/admin/productInventory";
	}

	@GetMapping("/editProduct/{id}")
	public String editProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.getProductById(id);

		model.addAttribute("product", product);

		return "editProduct";
	}

	@PostMapping("/editProduct")
	public String editProductPost(@Valid @ModelAttribute("product") Product product, BindingResult result, HttpServletRequest request) {

		if (result.hasErrors()) {
			return "editProduct";
		}

		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String path = rootDirectory + "/WEB-INF/resources/images/" + product.getProductId() + ".png";

		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(path));
			} catch (Exception ex) {
				ex.printStackTrace();
				throw new RuntimeException("Product image saving failed", ex);
			}
		}

		productService.editProduct(product);

		return "redirect:/admin/productInventory";
	}

	@GetMapping("/deleteProduct/{id}")
	public String deleteProduct(@PathVariable int id, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		String path = rootDirectory + "/WEB-INF/resources/images/" + id + ".png";

		//!!!

		Product product = productService.getProductById(id);
		productService.deleteProduct(product);

		return "redirect:/admin/productInventory";
	}
}
