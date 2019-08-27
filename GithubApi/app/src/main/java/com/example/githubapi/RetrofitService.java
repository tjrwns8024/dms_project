package com.example.githubapi;

import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("users/{user}")
    Call<jsonparse> getListRepos(@Path("user") String id);
}

