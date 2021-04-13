package com.example.gastos.elite_fragment;

public class eliteItemView {
    String restaurantImageUrl;
    String restaurantName;

    public eliteItemView(String restaurantImageUrl,String restaurantName)
    {
        this.restaurantImageUrl = restaurantImageUrl;
        this.restaurantName = restaurantName;
    }

    public String getRestaurantImageUrl() {
        return restaurantImageUrl;
    }

    public String getRestaurantName() {
        return restaurantName;
    }
}
