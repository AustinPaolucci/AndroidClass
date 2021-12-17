package com.example.dog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dog.APIModels.DogDetails;
import com.example.dog.RetrofitHelperClass.RetrofitHelper;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedDogView extends AppCompatActivity {

    DogDetails doggo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_dog_view);

        Intent intent = getIntent();

        int selectedDoggoId = intent.getIntExtra("REQUESTED_DOGGO_ID", 1);

        Call<List<DogDetails>> call = RetrofitHelper.getInstance().getApi().getDogDetails(selectedDoggoId);
        call.enqueue(new Callback<List<DogDetails>>() {
            @Override
            public void onResponse(Call<List<DogDetails>> call, Response<List<DogDetails>> response) {
                List<DogDetails> details = response.body();
                assert details != null;
                ArrayList<DogDetails> doggoList = new ArrayList<>(details);
                DogDetails selectedDoggo = doggoList.get(0);

                TextView breedName = findViewById(R.id.breedName);
                breedName.setText(selectedDoggo.getBreedName());

                TextView temperament = findViewById(R.id.temperamentDetail);
                temperament.setText(selectedDoggo.getTemperament());
                TextView lifeSpan = findViewById(R.id.LifeSpanDetail);
                lifeSpan.setText(selectedDoggo.getLifeSpan());
                TextView bredFor = findViewById(R.id.BredForDetail);
                bredFor.setText(selectedDoggo.getBredFor());
                ImageView doggoImage = findViewById(R.id.dogImage);
                Picasso.with(getApplicationContext())
                        .load(selectedDoggo.getImageId())
                        .into(doggoImage);
            }

            @Override
            public void onFailure(Call<List<DogDetails>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Failed to Fetch API", Toast.LENGTH_LONG).show();
                Log.d("SELECTED DOGGO" , "FAILED TO GET DOGGO", t);

            }
        });
    }
}