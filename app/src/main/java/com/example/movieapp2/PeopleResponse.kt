package com.example.movieapp2

data class PeopleResponse(
    val results: List<Person>
)

data class Person(
    val id: Int,
    val name: String,
    val profile_path: String?,
    val known_for: List<KnownFor>
)

data class KnownFor(
    val title: String?,
    val name: String?, // For TV shows
    val poster_path: String?
)
