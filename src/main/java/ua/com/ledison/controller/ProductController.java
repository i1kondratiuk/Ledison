package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.ledison.entity.Product;
import ua.com.ledison.service.ProductService;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // read - all

//    @GetMapping("/productList/all")
//    public String getProducts(Model model){
//        List<Product> products = productService.getProductList();
//        String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator;
//        model.addAttribute("products", products);
//        model.addAttribute("homePath", homePath);
//        System.out.println(products);
//
//        return "productList";
//    }

    // read - all paginated

    @GetMapping("/productList/all/{pageNumber}")
    public String getProducts(@PathVariable Integer pageNumber, Model model) {
        Page<Product> page = productService.findPaginated(pageNumber);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("products", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("currentIndex", current);
        model.addAttribute("endIndex", end);

        return "productList";
    }

    @GetMapping("/viewProduct/{productId}")
    public String viewProduct(@PathVariable int productId, Model model) throws IOException{
        Product product = productService.getProductById(productId);
        model.addAttribute("product", product);

        return "viewProduct";
    }


    @PostMapping("/productList")
    public String getProductByCategory(@RequestParam String searchCondition, Model model){
        List<Product> products = productService.getProductList();
        model.addAttribute("products", products);
        model.addAttribute("searchCondition", searchCondition);

        return "productList";
    }

}
