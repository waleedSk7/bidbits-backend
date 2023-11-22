package com.waleed.oopsproject.Bids;

import com.waleed.oopsproject.Products.ProductModel;
import jakarta.persistence.*;

@Entity
@Table(name = "bids")
public class BidModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bidId")
    private int bidId;

    @Column(name = "userId")
    private String userId;

    @Column(name = "bid")
    private int bid;

    @ManyToOne(targetEntity = ProductModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private Long productId;

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

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getProductId() {
        return productId;
    }
}
