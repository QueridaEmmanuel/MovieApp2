package com.example.movieapp2

class MovieRepository {
    private val movieApi = MovieService.create()

    suspend fun getNowPlayingMovies(apiKey: String): List<Movie> {
        return movieApi.getNowPlayingMovies(apiKey).results
    }

    suspend fun getPopularPeople(apiKey: String): List<Person> {
        return movieApi.getPopularPeople(apiKey).results
    }
}
