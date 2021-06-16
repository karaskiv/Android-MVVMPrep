package com.example.mvvmprep.network;

import com.example.mvvmprep.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {

    @GET("volley_array_json")
    Call<List<MovieModel>> getMovieList();
}
