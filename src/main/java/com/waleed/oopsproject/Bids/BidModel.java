package com.waleed.oopsproject.Bids;

public class BidModel {
    private String userId;
    private int bid;

    private String productId;

    public BidModel(String userId, int bid) {
        this.userId = userId;
        this.bid = bid;
    }

    public BidModel() {
    }

    public String getUserId() {
        return userId;
    }

    public int getBid() {
        return bid;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
