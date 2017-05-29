package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.*;
import ua.com.ledison.service.PowerService;
import ua.com.ledison.service.ProductManufacturerService;
import ua.com.ledison.service.ProductService;
import ua.com.ledison.service.WarrantyPeriodService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private PowerService powerService;
    @Autowired
    private WarrantyPeriodService warrantyPeriodService;
    @Autowired
    private ProductManufacturerService productManufacturerService;

    @GetMapping("/productList/all")
    public String getProducts(Model model) {
        List<ProductManufacturer> productManufacturers = productManufacturerService.getProductManufacturerList();
        List<Power> powers= powerService.getPowerList();
        List<WarrantyPeriod> warrantyPeriods = warrantyPeriodService.getWarrantyPeriodList();

        model.addAttribute("productManufacturers", productManufacturers);
        model.addAttribute("capTypes", CapType.values());
        model.addAttribute("glowColors", GlowColor.values());
        model.addAttribute("lampShapes", LampShape.values());
        model.addAttribute("diffuserType", DiffuserType.values());
        model.addAttribute("operatingVoltages", OperatingVoltage.values());
        model.addAttribute("powers", powers);
        model.addAttribute("warrantyPeriods", warrantyPeriods);

        return "productList";
    }

    @GetMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException {
        Product product = productService.getProductByIdAndFetchLazyCartItemList(productId);
        product.setProductViewCounter(product.getProductViewCounter() + 1);
        productService.editProduct(product);

        model.addAttribute("product", product);
        model.addAttribute("productImage", product.getProductImage());

        return "viewProduct";
    }

}