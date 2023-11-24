package com.waleed.oopsproject.Bids;

import com.waleed.oopsproject.Products.ProductModel;
import com.waleed.oopsproject.Users.UserModel;
import jakarta.persistence.*;

@Entity
@Table(name = "bids")
public class BidModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bid_id")
    private Long bidId;

    @ManyToOne(targetEntity = UserModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserModel userId;

    @Column(name = "bid")
    private int bid;

    @ManyToOne(targetEntity = ProductModel.class)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private ProductModel product;

    public BidModel(UserModel userId, int bid, ProductModel product) {
        this.userId = userId;
        this.bid = bid;
        this.product = product;
    }

    public BidModel() {

    }

    public Long getUserId() {
        return userId.getUserId();
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public void setUser(UserModel userId) {
        this.userId = userId;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
    }

    public ProductModel getProduct() {
        return product;
    }
}
