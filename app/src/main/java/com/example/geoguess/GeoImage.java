package com.example.geoguess;

public class GeoImage {

    private int imageId;
    private boolean europe;

    public GeoImage(int imageId, boolean europe) {
        this.imageId = imageId;
        this.europe = europe;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isEurope() {
        return europe;
    }

    public void setEurope(boolean europe) {
        this.europe = europe;
    }
}
