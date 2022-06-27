package com.in.architectureapp.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("category")
    private String category;


    public Country(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

}
