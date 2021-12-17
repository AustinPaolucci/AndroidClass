package com.example.dog.APIModels;

import com.google.gson.annotations.SerializedName;

public class DogID {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String breedName;

    public int getId() {
        return id;
    }

    public String getBreedName() {
        return breedName;
    }
}
