package com.waleed.oopsproject.Users;


import com.waleed.oopsproject.Bids.BidModel;
import com.waleed.oopsproject.Products.ProductModel;
import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "campus_id", unique = true)
    private String campusID;

    @Column(name ="hostel")
    private String hostel;

    public String getHostel() {
        return hostel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCampusID(String campusID) {
        this.campusID = campusID;
    }

    public void setHostel(String hostel) {
        this.hostel = hostel;
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCampusID() {
        return campusID;
    }

    public void setName(String name) {
        this.name = name;
    }

}
