package com.swproject.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("/getAllProducts")
    public Page<Product> getAllProducts(@RequestParam(defaultValue = "0") int pageNumber, 
                                        @RequestParam(defaultValue = "") String searchKey) {

        return productService.getAllProducts(pageNumber, searchKey);

    }
    
    @GetMapping("/getProductDetailsById/{productId}")
    public Product getProductDetailsById(@PathVariable("productId") Integer productId) {
        return productService.getProductDetailsById(productId);
    }
}

