package com.waleed.oopsproject.Bids;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Products.ProductRepository;
import com.waleed.oopsproject.Users.UserModel;
import com.waleed.oopsproject.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class BidService  {
    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    public List<BidModel> getAllBids() {
        return bidRepository.findAllBy();
    }


    public BidModel addBid(BidModel bidModel, Long productId, Long userId) {
        ProductModel productModel = productRepository.findById(productId).orElse(null);
        assert productModel != null;
        bidModel.setProduct(productModel);
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        bidRepository.findByUserId(userModel).ifPresent(bidModel1 -> bidRepository.delete(bidModel1));
        System.out.println(userModel);
        System.out.println(productModel);
        assert productModel.getUser() == userModel;
        bidModel.setUser(userModel);
        return bidRepository.save(bidModel);
    }

    public Iterable<BidModel> getBidsByUserId(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        return bidRepository.findAllByUserId(userModel);
    }

    public int getHighestBid(Long productId) {
        ProductModel productModel = productRepository.findById(productId).orElse(null);
        assert productModel != null;
        List<BidModel> bidModels = bidRepository.findAllByProduct(productModel);
        int highestBid = 0;
        for (BidModel bidModel : bidModels) {
            if (bidModel.getBid() > highestBid) {
                highestBid = bidModel.getBid();
            }
        }
        return highestBid;
    }

    public BidModel freezeBid(Long bidId, Long userId) {
        BidModel bidModel = bidRepository.findById(bidId).orElse(null);
        assert bidModel != null;
        bidModel.setFrozen(true);
        ProductModel productModel = bidModel.getProduct();
        assert productModel != null;
        productModel.setSold(true);
        productRepository.save(productModel);
        bidRepository.save(bidModel);
        return bidModel;
    }

    // Get all the products a user has bid on.
    public Iterable<ProductModel> getProductsByUserId(Long userId) {
        UserModel userModel = userRepository.findById(userId).orElse(null);
        assert userModel != null;
        Iterable<BidModel> bids = bidRepository.findAllByUserId(userModel);
        HashSet<ProductModel> products = new HashSet<>();
        for (BidModel bid : bids) {
            products.add(bid.getProduct());
        }
        return products;
    }
}
