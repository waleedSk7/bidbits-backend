package com.waleed.oopsproject.Bids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BidService  {
    @Autowired
    private BidRepository bidRepository;

    public List<BidModel> getAllBids() {
        return bidRepository.findAllBy();
    }


}
