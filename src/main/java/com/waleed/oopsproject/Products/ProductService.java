package com.waleed.oopsproject.Products;

import com.waleed.oopsproject.Bids.BidModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    // Create
    public ProductModel addProduct(ProductModel productModel) {
        return productRepository.save(productModel);
    }

    // Read
    public ProductModel getProductById(String productId) {
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
        existingProduct.setSellerId(productModel.getSellerId());
        existingProduct.setStartingBid(productModel.getStartingBid());
        existingProduct.setBids(productModel.getBids());
        return productRepository.save(existingProduct);
    }

    // Add bid
    public ProductModel addBid(String productId, int bid) {
        ProductModel existingProduct = productRepository.findById(productId).orElse(null);
        assert existingProduct != null;
        BidModel[] bids = existingProduct.getBids();
        BidModel[] newBids = new BidModel[bids.length + 1];
        System.arraycopy(bids, 0, newBids, 0, bids.length);
        newBids[bids.length] = new BidModel("userId", bid);
        existingProduct.setBids(newBids);
        return productRepository.save(existingProduct);
    }

    // Delete
    public String deleteProduct(String productId) {
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

    // Get by seller
    public Iterable<ProductModel> getProductsBySellerId(String sellerId) {
        return productRepository.findBySellerId(sellerId).orElse(null);
    }
}
