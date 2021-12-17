package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dog.APIModels.Breeds;
import com.example.dog.APIModels.DogID;
import com.example.dog.RecyclerView.recyclerViewDogAdapter;
import com.example.dog.RetrofitHelperClass.RetrofitHelper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private recyclerViewDogAdapter mAdapter;
    private ArrayList<DogID> breedList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.dogList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Call<List<DogID>> call = RetrofitHelper.getInstance().getApi().getDogBreeds();
        call.enqueue(new Callback<List<DogID>>() {
            @Override
            public void onResponse(Call<List<DogID>> call, Response<List<DogID>> response) {
                List<DogID> myBreedList = response.body();
                assert myBreedList != null;
                breedList.addAll(myBreedList);
                mAdapter = new recyclerViewDogAdapter(getApplicationContext(), breedList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<DogID>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to Fetch API", Toast.LENGTH_LONG).show();
            }
        });


    }


}