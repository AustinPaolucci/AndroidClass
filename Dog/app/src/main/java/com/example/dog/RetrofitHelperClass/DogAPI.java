package com.example.dog.RetrofitHelperClass;

import com.example.dog.APIModels.Breeds;
import com.example.dog.APIModels.DogDetails;
import com.example.dog.APIModels.DogID;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DogAPI {
    String url = "https://api.thedogapi.com/v1/";

    @GET("breeds")
    Call<List<DogID>> getDogBreeds();

    @GET("images/search")
    Call<List<DogDetails>> getDogDetails(@Query("breed_ids") int id);


}
