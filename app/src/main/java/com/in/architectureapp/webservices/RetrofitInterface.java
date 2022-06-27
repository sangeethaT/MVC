package com.in.architectureapp.webservices;


import com.in.architectureapp.model.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitInterface
{
    @GET("feeds/flowers.json")
    Call<List<Country>> getCountry();

   // @GET("all")
   // void getCountry(Call<List<String>> countries);


}