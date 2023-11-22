package com.waleed.oopsproject.Bids;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api/v1/bids")
public class BidController {
    @Autowired
    private BidService bidService;

    // Read

    // Update
    // Delete
    // Get all
    // Get by category
}
