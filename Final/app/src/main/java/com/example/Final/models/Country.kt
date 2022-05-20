package com.example.Final.models

import com.google.gson.annotations.SerializedName

data class Country (
    @SerializedName("Country")
    val country: String,
    @SerializedName("Slug")
    val slug: String,
    @SerializedName("ISO2")
    val ISO2: String
)