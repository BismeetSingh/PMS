package com.app.bissudroid.myapplication.service;

import com.app.bissudroid.myapplication.model.DiamondDetails;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface PMSService {
    String ENDPOINT = "http://192.168.43.166/PMS/";
    @FormUrlEncoded
    @POST("login.php")
    Call<Integer> login(@Field("email") String email, @Field("password") String password);
    @GET("getRingDetails.php")
    Call<List<DiamondDetails>> getDiamondDetails();
    @FormUrlEncoded
    @POST("updatePhases.php")
    Call<ResponseBody> updatePhases(@Field("sale_id")int sale_id, @Field("phase_CAD")int phase_CAD,
                                    @Field("phase_CASTING")int phase_CASTING,
                                    @Field("phase_FILING")int phase_FILING,
                                    @Field("phase_SETTING")int phase_SETTING,
                                    @Field("phase_FINISHING")int phase_FINISHING,
                                    @Field("phase_DISPATCH")int phase_DISPATCH);
    @FormUrlEncoded
    @POST("deletePhases.php")
    Call<ResponseBody> deleteSale(@Field("saleid")int  saleid);

}
