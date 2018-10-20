package com.app.bissudroid.myapplication.model;

public class DiamondDetails {
    private int image;
    private String tagline;
    private String diamond_color;
    private String metal_color;
    private String clarity;

    private String metal_type;
    private String metal_purity;
    private String ringSize;
    private String productCode;

    public DiamondDetails(String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize) {
        this.tagline = tagline;
        this.diamond_color = diamond_color;
        this.metal_color = metal_color;
        this.clarity = clarity;
        this.metal_type = metal_type;
        this.metal_purity = metal_purity;
        this.ringSize = ringSize;
    }

    public int getImage() {
        return image;
    }

    public String getTagline() {
        return tagline;
    }

    public String getDiamond_color() {
        return diamond_color;
    }

    public String getMetal_color() {
        return metal_color;
    }


    public String getClarity() {
        return clarity;
    }

    public String getMetal_type() {
        return metal_type;
    }

    public String getMetal_purity() {
        return metal_purity;
    }

    public String getRingSize() {
        return ringSize;
    }

    public String getProductCode() {
        return productCode;
    }

    public DiamondDetails(int image, String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize, String productCode) {

        this.image = image;
        this.tagline = tagline;
        this.diamond_color = diamond_color;
        this.metal_color = metal_color;
        this.clarity = clarity;
        this.metal_type = metal_type;
        this.metal_purity = metal_purity;
        this.ringSize = ringSize;
        this.productCode = productCode;
    }

}
