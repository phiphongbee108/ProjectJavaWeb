package com.backend.controller.restAPI;

import com.backend.models.Product;
import com.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("be/")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add-product")
    public Boolean createProduct(@ModelAttribute Product product) {
        productService.createOrUpdate(product);
        return true;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct() {
        List<Product> list = productService.getAllProduct();
        return list;
    }

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    @DeleteMapping("/delete-product/{id}")
    public Boolean deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return true;
    }

    @GetMapping("/edit-product/{id}")
    public Product editProduct(@PathVariable Long id) {
        return productService.eidtProduct(id);
    }

    @PutMapping("/update-product/{id}")
    public Boolean updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        //code
        return true;
    }
}
