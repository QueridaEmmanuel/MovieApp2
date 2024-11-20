package com.example.movieapp2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

object MovieService {
    private const val BASE_URL = "https://api.themoviedb.org/3/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): MovieApi {
        return retrofit.create(MovieApi::class.java)
    }
}

interface MovieApi {
    @GET("movie/now_playing")
    suspend fun getNowPlayingMovies(
        @Query("api_key") apiKey: String
    ): MovieResponse

    @GET("person/popular")
    suspend fun getPopularPeople(
        @Query("api_key") apiKey: String
    ): PeopleResponse
}