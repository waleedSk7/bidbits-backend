package com.waleed.oopsproject.Products;

import com.waleed.oopsproject.Bids.BidModel;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
public class ProductModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productId", insertable = false, updatable = false)
    private Long id;
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

    @ManyToOne(targetEntity = BidModel.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "productId", referencedColumnName = "productId")
    private BidModel[] bids;

    public void setBids(BidModel[] bids) {
        this.bids = bids;
    }

    public BidModel[] getBids() {
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

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }

    public Long getProductId() {
        return id;
    }


}
