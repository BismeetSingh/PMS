package com.app.bissudroid.myapplication.service;

import com.app.bissudroid.myapplication.model.DiamondDetails;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PMSService {
    String ENDPOINT = "http://192.168.0.7/PMS/";
    @FormUrlEncoded
    @POST("login.php")
    Call<Integer> login(@Field("email") String email, @Field("password") String password);
    @GET("getRingDetails.php")
    Call<List<DiamondDetails>> getDiamondDetails();

}
