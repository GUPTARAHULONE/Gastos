package com.example.gastos.deals_fragment;

public class Model_offer {
    int image;
    int pos;


    public Model_offer(int image, int pos) {
        this.image = image;
        this.pos = pos;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }
}
