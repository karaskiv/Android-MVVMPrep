package com.example.mvvmprep.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mvvmprep.model.MovieModel;
import com.example.mvvmprep.network.APIService;
import com.example.mvvmprep.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieList;

    public MovieListViewModel() {
        movieList = MutableLiveData<>();
    }

    public MutableLiveData<List<MovieModel>> getMovieListObserver() {
        return movieList;
    }

    public void makeApiCall() {
        APIService apiService = RetroInstance.getRetroClient().create(APIService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
