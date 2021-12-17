package com.example.dog.RetrofitHelperClass;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHelper {
    private static RetrofitHelper client = null; //its a singleton!
    private DogAPI dogApi;

    private RetrofitHelper(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(dogApi.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        dogApi = retrofit.create(DogAPI.class);
    }

    public static synchronized RetrofitHelper getInstance(){
        if(client == null){
            client = new RetrofitHelper();
        }
        return client;
    }

    public DogAPI getApi(){
        return dogApi;
    }
}
