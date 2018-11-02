package com.app.bissudroid.myapplication.model;

import android.os.Parcel;
import android.os.Parcelable;

public class DiamondDetails implements Parcelable {
    private String image;
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
    private String diamondWeight;
    private String diamondCut;
    private int ringId;
    private int arr[];

    public void setPhase_CAD(int phase_CAD) {
        this.phase_CAD = phase_CAD;
    }

    public void setPhase_CASTING(int phase) {
        this.phase_CASTING = phase;
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

    public DiamondDetails(int sale_id, String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize, int phase_CAD, int phase_CASTING, int phase_FILING, int phase_SETTING, int phase_FINISHING, int phase_DISPATCH,
                          String diamondCut,String diamondWeight,int ringId) {

        this.sale_id = sale_id;
        this.tagline = tagline;
        this.diamond_color = diamond_color;
        this.ringId=ringId;
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
        this.diamondCut=diamondCut;
        this.diamondWeight=diamondWeight;
        this.phase_FINISHING = phase_FINISHING;
        this.phase_DISPATCH = phase_DISPATCH;
    }

    public String getDiamondCut() {
        return diamondCut;
    }

    public int getRingId() {
        return ringId;
    }

    public DiamondDetails(String image, int sale_id, String tagline, String diamond_color, String metal_color, String clarity, String metal_type, String metal_purity, String ringSize, int phase_CAD, int phase_CASTING, int phase_FILING, int phase_SETTING, int phase_FINISHING, int phase_DISPATCH,
                          String diamondCut, String diamondWeight, int ringId) {

        this.image = image;
        this.sale_id = sale_id;
        this.tagline = tagline;
        this.diamond_color = diamond_color;

        this.metal_color = metal_color;
        this.clarity = clarity;
        this.metal_type = metal_type;
        this.diamondCut=diamondCut;
        this.diamondWeight=diamondWeight;
        this.metal_purity = metal_purity;
        this.ringSize = ringSize;
//        this.productCode = productCode;
        this.ringId=ringId;
        this.phase_CAD = phase_CAD;
        this.phase_CASTING = phase_CASTING;
        this.phase_FILING = phase_FILING;
        this.phase_SETTING = phase_SETTING;
        this.phase_FINISHING = phase_FINISHING;
        this.phase_DISPATCH = phase_DISPATCH;
    }

    public String getImage() {
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


    @Override
    public int describeContents() {
        return 0;
    }

    public String getDiamondWeight() {
        return diamondWeight;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(image);
        dest.writeInt(sale_id);
        dest.writeString(tagline);
        dest.writeString(diamond_color);
        dest.writeString(metal_color);
        dest.writeString(clarity);
        dest.writeString(metal_type);
        dest.writeString(metal_purity);
        dest.writeString(ringSize);
        dest.writeInt(phase_CAD);
        dest.writeIntArray(arr);
        dest.writeString(diamondCut);
        dest.writeString(diamondWeight);
        dest.writeInt(ringId);




    }
    public static final Parcelable.Creator<DiamondDetails> CREATOR
            = new Parcelable.Creator<DiamondDetails>() {
        public DiamondDetails createFromParcel(Parcel in) {
            return new DiamondDetails(in);
        }

        public DiamondDetails[] newArray(int size) {
            return new DiamondDetails[0];
        }
    };

    private DiamondDetails(Parcel parcel) {
        image=parcel.readString();
        sale_id=parcel.readInt();
        tagline=parcel.readString();
        diamond_color=parcel.readString();
        metal_color=parcel.readString();
        clarity=parcel.readString();
        metal_type=parcel.readString();
        metal_purity=parcel.readString();
        ringSize=parcel.readString();
        phase_CAD=parcel.readInt();
        diamondCut=parcel.readString();
        diamondWeight=parcel.readString();
        ringId=parcel.readInt();
//        arr=parcel.createIntArray();

    }
}
