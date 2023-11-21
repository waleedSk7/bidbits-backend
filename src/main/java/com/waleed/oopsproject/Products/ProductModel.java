package com.waleed.oopsproject.Products;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId")
    private String name;
    @Column(name = "productName")
    private String productName;

    @Column(name= "image")
    private String image;

    @Column(name= "details")
    private String details;

    @Column(name= "category")
    private String category;

    @Column(name="sellerId")
    private String sellerId;

    @Column(name="startingBid")
    private int startingBid;

    @Column(name="bids")
    private int[] bids;

    public void setBids(int[] bids) {
        this.bids = bids;
    }

    public int[] getBids() {
        return bids;
    }

    public void setStartingBid(int startingBid) {
        this.startingBid = startingBid;
    }

    public int getStartingBid() {
        return startingBid;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }


}
