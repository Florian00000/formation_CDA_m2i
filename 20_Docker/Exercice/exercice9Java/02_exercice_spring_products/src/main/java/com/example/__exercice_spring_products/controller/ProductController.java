package com.example.__exercice_spring_products.controller;

import com.example.__exercice_spring_products.model.Product;
import com.example.__exercice_spring_products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "productsList";
    }

    @GetMapping("/products/{id}")
    public String getProductById(@PathVariable("id") UUID id, Model model) {
        Product product = productService.getProduct(id);
        model.addAttribute("product", product);

        return "productDetail";
    }

    @GetMapping("/products/filter")

    public String filterBy(@RequestParam(name = "category", required = false) String category,
                                  @RequestParam(name = "price", required = false) Double price,
                           Model model) {
        if(category != null){
             model.addAttribute("products", productService.getAllProducts().stream()
                     .filter(product -> product.getCategory().equalsIgnoreCase(category))
                     .toList());
        } else if  (price != null) {
            model.addAttribute("products", productService.getAllProducts().stream()
                    .filter(product -> product.getPrice() < price)
                    .toList());
        }
        else {
            return "redirect:/products";
        }

        return "productsList";
    }

}
