package com.example.movieapi_recommend.data.model

import com.google.gson.annotations.SerializedName

//Model class -> helps data formatting , like templates
//Represents JSON Array
data class Movie(

    @SerializedName("results")
    val movieList : List<MovieItem>
)
