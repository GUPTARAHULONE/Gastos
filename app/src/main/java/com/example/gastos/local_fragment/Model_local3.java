package com.example.gastos.local_fragment;

public class Model_local3 {

  String Address,Category,OwnerName,Rating,shop_Name;
   String image;

   // int img1,posii;

    public Model_local3() {
    }

    public Model_local3(String address, String category, String ownerName, String rating,  String image, String shop_Name) {
        Address = address;
        Category = category;
        OwnerName = ownerName;
        Rating = rating;
        this.image = image;
        this.shop_Name = shop_Name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getOwnerName() {
        return OwnerName;
    }

    public void setOwnerName(String ownerName) {
        OwnerName = ownerName;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public  String getImage() {
        return image;
    }

    public void setImage( String image) {
        this.image = image;
    }

    public String getShop_Name() {
        return shop_Name;
    }

    public void setShop_Name(String shop_Name) {
        this.shop_Name = shop_Name;
    }
}
