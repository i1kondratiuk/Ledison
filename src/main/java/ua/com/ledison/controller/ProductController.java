package ua.com.ledison.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import ua.com.ledison.entity.Product;
import ua.com.ledison.exception.MyResourceNotFoundException;
import ua.com.ledison.service.ProductService;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    // read - all

    @GetMapping("/productList/all")
    public String getProducts(Model model){
        List<Product> products = productService.getProductList();
        String homePath = System.getProperty("user.home") + File.separator + "images" + File.separator;
        model.addAttribute("products", products);
        model.addAttribute("homePath", homePath);
        System.out.println(products);

        return "productList";
    }

    // read - all paginated

    @RequestMapping(value = "/productList/all", params = { "page", "size" }, method = RequestMethod.GET)
    @ResponseBody
    public List<Product> findPaginated(@RequestParam("page") final int page, @RequestParam("size") final int size, final UriComponentsBuilder uriBuilder, final HttpServletResponse response) {
        final Page<Product> resultPage = productService.findPaginated(page, size);
        if (page > resultPage.getTotalPages()) {
            throw new MyResourceNotFoundException();
        }

        return resultPage.getContent();
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
