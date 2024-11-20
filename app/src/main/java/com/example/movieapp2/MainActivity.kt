package com.example.movieapp2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val movieRepository = MovieRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val moviesButton = findViewById<Button>(R.id.moviesButton)
        val peopleButton = findViewById<Button>(R.id.peopleButton)

        moviesButton.setOnClickListener {
            loadMovies(recyclerView)
        }

        peopleButton.setOnClickListener {
            loadPeople(recyclerView)
        }

        // Default to loading movies
        loadMovies(recyclerView)
    }

    private fun loadMovies(recyclerView: RecyclerView) {
        lifecycleScope.launch {
            val apiKey = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
            val movies = movieRepository.getNowPlayingMovies(apiKey)
            recyclerView.adapter = MovieAdapter(movies)
        }
    }

    private fun loadPeople(recyclerView: RecyclerView) {
        lifecycleScope.launch {
            val apiKey = "a07e22bc18f5cb106bfe4cc1f83ad8ed"
            val people = movieRepository.getPopularPeople(apiKey)
            recyclerView.adapter = PersonAdapter(people)
        }
    }
}
