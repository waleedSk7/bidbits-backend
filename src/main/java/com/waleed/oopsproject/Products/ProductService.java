package com.waleed.oopsproject.Products;

import com.waleed.oopsproject.Bids.BidModel;
import com.waleed.oopsproject.Bids.BidRepository;
import com.waleed.oopsproject.Users.UserModel;
import com.waleed.oopsproject.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private UserRepository userRepository;

    // Create
    public ProductModel addProduct(ProductModel productModel, Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        productModel.setUser(userModel);
        return productRepository.save(productModel);
    }

    // Read
    public ProductModel getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    // Update
    public ProductModel updateProduct(ProductModel productModel) {
        ProductModel existingProduct = productRepository.findById(productModel.getProductId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setProductName(productModel.getProductName());
        existingProduct.setImage(productModel.getImage());
        existingProduct.setDetails(productModel.getDetails());
        existingProduct.setCategory(productModel.getCategory());
        existingProduct.setUser(productModel.getUser());
        existingProduct.setStartingBid(productModel.getStartingBid());
        return productRepository.save(existingProduct);
    }

    // Delete
    public String deleteProduct(Long productId) {
        productRepository.deleteById(productId);
        return "Product removed !! " + productId;
    }

    // Get all
    public Iterable<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    // Get by category
    public Iterable<ProductModel> getProductsByCategory(String category) {
        return productRepository.findByCategory(category);
    }
}
