package com.waleed.oopsproject.Bids;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Products.ProductRepository;
import com.waleed.oopsproject.Users.UserModel;
import com.waleed.oopsproject.Users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
