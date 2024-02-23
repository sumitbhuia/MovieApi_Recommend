package com.example.movieapi_recommend.data.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

//Represents JSON Object
//Entity class -> also used by ROOM Architecture
//Model class -> helps data formatting , like templates
@Entity("popular_movies")
data class MovieItem(

    @SerializedName("id")
    val MovieId:Int ,
    @SerializedName("overview")
    val overview : String ,
    @SerializedName("title")
    val title : String ,
    @SerializedName("poster_path")
    val posterPath : String ,
    @SerializedName("release_date")
    val releaseDate : String

)

