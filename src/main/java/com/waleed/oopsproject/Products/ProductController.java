package com.waleed.oopsproject.Products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    // Create
    @PostMapping(path = "/")
    public ProductModel addProduct(@RequestBody ProductModel productModel) {
        return productService.addProduct(productModel);
    }

    // Read
    @GetMapping(path = "/")
    public ProductModel getProductById(@RequestParam Long productId) {
        return productService.getProductById(productId);
    }

    // Update
    @PostMapping(path = "/update")
    public ProductModel updateProduct(@RequestBody ProductModel productModel) {
        return productService.updateProduct(productModel);
    }

    // Add bid
    @PostMapping(path = "/addBid")
    public ProductModel addBid(@RequestParam Long productId,@RequestBody int bid) {
        return productService.addBid(productId, bid);
    }

    // Delete
    @DeleteMapping(path = "/")
    public String deleteProduct(@RequestParam Long productId) {
        return productService.deleteProduct(productId);
    }

    // Get all
    @GetMapping(path = "/list")
    public Iterable<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    // Get by category
    @GetMapping(path = "/listByCategory")
    public Iterable<ProductModel> getProductsByCategory(@RequestParam String category) {
        return productService.getProductsByCategory(category);
    }

    @DeleteMapping(path="/deleteBids")
    public String deleteBids(@RequestParam Long productId) {
        return productService.deleteBids(productId);
    }

}
