package com.waleed.oopsproject.Bids;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Users.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository  extends JpaRepository<BidModel, Long> {

    List<BidModel> findAllBy();

    void deleteByUserId(UserModel userId);

    Optional<BidModel> findByUserId(UserModel userId);

    List<BidModel> findAllByUserId(UserModel userId);

    List<BidModel> findAllByProduct(ProductModel productModel);
}
