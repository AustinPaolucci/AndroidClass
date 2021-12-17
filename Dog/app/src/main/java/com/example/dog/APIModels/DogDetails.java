package com.example.dog.APIModels;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class DogDetails {

    @SerializedName("breeds")
    private Breeds[] doginfo;

    @SerializedName("url")
    private String imageId;

    public String getBreedName() {
        return doginfo[0].getBreedName();
    }

    public String getBredFor() {
        return doginfo[0].getBredFor();
    }

    public String getLifeSpan() {
        return doginfo[0].getLifeSpan();
    }

    public String getTemperament() {
        return doginfo[0].getTemperament();
    }

    public String getImageId() {
        return imageId;
    }

}
