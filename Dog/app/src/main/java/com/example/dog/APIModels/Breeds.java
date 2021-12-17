package com.example.dog.APIModels;

import com.google.gson.annotations.SerializedName;

public class Breeds {
    @SerializedName("id")
    private int id;

    @SerializedName("name")
    private String breedName;

    @SerializedName("bred_for")
    private String bredFor;

    @SerializedName("life_span")
    private String lifeSpan;

    @SerializedName("temperament")
    private String temperament;

    public String getName(){
        return breedName;
    }

    public String getBreedName() {
        return breedName;
    }

    public String getBredFor() {
        return bredFor;
    }

    public String getLifeSpan() {
        return lifeSpan;
    }

    public String getTemperament() {
        return temperament;
    }
    public int getId() {
        return id;
    }
}
