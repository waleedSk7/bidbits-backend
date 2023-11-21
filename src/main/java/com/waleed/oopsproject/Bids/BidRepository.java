package com.waleed.oopsproject.Bids;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BidRepository {
    Optional<BidModel> findByProductId(String productId);

    BidModel save(BidModel bidModel);

    void deleteByProductId(String productId);

    void deleteByUserId(String userId);

    Optional<BidModel> findByUserId(String userId);

}
