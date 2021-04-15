package com.example.gastos.elite_fragment;

public class eliteItemView {
    String imageUrl;
    String imageName;

    public eliteItemView(String imageUrl,String imageName)
    {
        this.imageUrl = imageUrl;
        this.imageName =imageName;
    }

    public String getRestaurantImageUrl() {
        return imageUrl;
    }

    public String getRestaurantName() {
        return imageName;
    }
}
