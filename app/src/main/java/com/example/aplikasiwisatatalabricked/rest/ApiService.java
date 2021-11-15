package com.example.aplikasiwisatatalabricked.rest;

import com.example.aplikasiwisatatalabricked.model.RootWisataModel;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("purwakarta/wisata") //endpoint
    Call<RootWisataModel> getData();
}