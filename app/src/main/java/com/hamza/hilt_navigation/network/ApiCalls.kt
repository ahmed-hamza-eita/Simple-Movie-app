package com.hamza.hilt_navigation.network

import com.hamza.hilt_navigation.Const
import com.hamza.hilt_navigation.data_model.DetailsModel
import com.hamza.hilt_navigation.data_model.MovieModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiCalls {


    @GET("discover/movie")
    suspend fun getMovie(@Query("api_key") apiKey: String = Const.API_KEY): MovieModel

    @GET("movie/{movie_id}")
    suspend fun getDetails(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String = Const.API_KEY
    ): DetailsModel

}