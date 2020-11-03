package com.example.eshop.controller;

import com.example.eshop.model.Product;
import com.example.eshop.service.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
public class ProductController {

    @Resource
    private ProductService productService;


    @GetMapping("/products")
    public String showProducts(Model model) {
        pushProductListToThymeleaf(model);
        return "product_list";
    }


    @GetMapping("/addProduct")
    public String showProductAddForm(Product product) {
        return "product_add";
    }

    @PostMapping("/products")
    public String addProduct(Product product, Model model) {
        productService.saveProduct(product);
        pushProductListToThymeleaf(model);
        return "redirect:/products";
    }

    @GetMapping("/removeProduct/{id}")
    public String removeProduct(@PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        productService.deleteProduct(product);
        pushProductListToThymeleaf(model);
        return "redirect:/products";

    }

    @GetMapping("/editProduct/{id}")
    public String showUpdateProducts(@PathVariable("id") long id, Model model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product_update";
    }

    @PostMapping("/updateProduct/{id}")
    public String updateUser(Model model, Product product) {
        productService.saveProduct(product);
        pushProductListToThymeleaf(model);
        return "redirect:/products";
    }

    private void pushProductListToThymeleaf(Model model) {
        model.addAttribute("products", productService.findAll());
    }


}
