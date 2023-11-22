package com.waleed.oopsproject.Bids;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BidRepository  extends JpaRepository<BidModel, Long> {

    List<BidModel> findAllBy();

    void deleteByUserId(String userId);

    Optional<BidModel> findByUserId(String userId);

}
