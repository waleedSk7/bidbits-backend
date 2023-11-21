package com.waleed.oopsproject.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Create
    @PostMapping(path = "/")
    public ProductModel addProduct(@RequestBody ProductModel productModel) {
        return productService.addProduct(productModel);
    }

    // Read
    @PostMapping(path = "/")
    public ProductModel getProductById(@RequestParam String productId) {
        return productService.getProductById(productId);
    }

    // Update
    @PostMapping(path = "/")
    public ProductModel updateProduct(ProductModel productModel) {
        return productService.updateProduct(productModel);
    }

    // Add bid
    @PostMapping(path = "/")
    public ProductModel addBid(String productId, int bid) {
        return productService.addBid(productId, bid);
    }

}
