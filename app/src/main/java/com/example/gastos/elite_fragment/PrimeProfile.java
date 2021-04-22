package com.example.gastos.elite_fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gastos.R;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class PrimeProfile extends AppCompatActivity {

    String imageUrl;
    String name;
    SliderAdapter adapter;
    ArrayList<SliderItem> sliderImages;
    SliderView sliderView;
    TextView txtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime_profile);

        sliderView = findViewById(R.id.imageSlider);
        txtName = findViewById(R.id.txtName);

        imageUrl = getIntent().getStringExtra("imageUrl");
        name = getIntent().getStringExtra("imageName");

        txtName.setText(name);

        dataFeed();
        adapter = new SliderAdapter(getApplicationContext() , sliderImages);

        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.COLOR); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollBarSize(sliderImages.size());
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);

    }

    private void dataFeed()
    {
        sliderImages = new ArrayList<>();
        sliderImages.add(new SliderItem(imageUrl , name));
        sliderImages.add(new SliderItem("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" , "Image2"));
        sliderImages.add(new SliderItem("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260" , "Image3"));
        sliderImages.add(new SliderItem("https://images.pexels.com/photos/929778/pexels-photo-929778.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260" , "Image4"));
        sliderImages.add(new SliderItem("https://images.pexels.com/photos/747964/pexels-photo-747964.jpeg?auto=compress&cs=tinysrgb&h=750&w=1260" , "Image5"));
    }
}