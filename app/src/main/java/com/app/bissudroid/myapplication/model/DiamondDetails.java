package com.app.bissudroid.myapplication.model;

public class DiamondDetails {
    private int image;
    private int sale_id;
    private String tagline;
    private String diamond_color;
    private String metal_color;
    private String clarity;

    private String metal_type;
    private String metal_purity;
    private String ringSize;
   // private String productCode;
    private int phase_CAD;
    private int arr[];

    public void setPhase_CAD(int phase_CAD) {
        this.phase_CAD = phase_CAD;
    }

    public void setPhase_CASTING(int phase_CASTING) {
        this.phase_CASTING = phase_CASTING;
    }

    public void setPhase_FILING(int phase_FILING) {
        this.phase_FILING = phase_FILING;
    }

    public void setPhase_SETTING(int phase_SETTING) {
        this.phase_SETTING = phase_SETTING;
    }

    public void setPhase_FINISHING(int phase_FINISHING) {
        this.phase_FINISHING = phase_FINISHING;
    }

    public void setPhase_DISPATCH(int phase_DISPATCH) {
        this.phase_DISPATCH = phase_DISPATCH;
    }

    public int[] getArr() {

        return arr;
    }

    public void setArr(int[] arr) {
        this.arr = arr;
    }

    private int phase_CASTING;
    private int phase_FILING;
    private int phase_SETTING;
    private int phase_FINISHING;
    private int phase_DISPATCH;


    public int getPhase_CAD() {
        return phase_CAD;
    }

    public int getPhase_CASTING() {
        return phase_CASTING;
    }

    public int getPhase_FILING() {
        return phase_FILING;
    }

    public int getPhase_SETTING() {
        return phase_SETTING;
    }

    public int getPhase_FINISHING() {
        return phase_FINISHING;
    }

    public int getPhase_DISPATCH() {
        return phase_DISPATCH;
    }

    public DiamondDetails(int sale_id, String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize, int phase_CAD, int phase_CASTING, int phase_FILING, int phase_SETTING, int phase_FINISHING, int phase_DISPATCH) {

        this.sale_id = sale_id;
        this.tagline = tagline;
        this.diamond_color = diamond_color;
        this.metal_color = metal_color;
        this.clarity = clarity;
        this.metal_type = metal_type;
        this.metal_purity = metal_purity;
        this.ringSize = ringSize;
//        this.productCode = productCode;
        this.phase_CAD = phase_CAD;
        this.phase_CASTING = phase_CASTING;
        this.phase_FILING = phase_FILING;
        this.phase_SETTING = phase_SETTING;
        this.phase_FINISHING = phase_FINISHING;
        this.phase_DISPATCH = phase_DISPATCH;
    }

    public DiamondDetails(int image, int sale_id, String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize, int phase_CAD, int phase_CASTING, int phase_FILING, int phase_SETTING, int phase_FINISHING, int phase_DISPATCH) {

        this.image = image;
        this.sale_id = sale_id;
        this.tagline = tagline;
        this.diamond_color = diamond_color;
        this.metal_color = metal_color;
        this.clarity = clarity;
        this.metal_type = metal_type;
        this.metal_purity = metal_purity;
        this.ringSize = ringSize;
//        this.productCode = productCode;
        this.phase_CAD = phase_CAD;
        this.phase_CASTING = phase_CASTING;
        this.phase_FILING = phase_FILING;
        this.phase_SETTING = phase_SETTING;
        this.phase_FINISHING = phase_FINISHING;
        this.phase_DISPATCH = phase_DISPATCH;
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

//    public String getProductCode() {
//        return productCode;
//    }

    public int getSale_id() {
        return sale_id;
    }



}
