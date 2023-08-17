package com.menesdurak.rickandmorty.data.dto

data class Character(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationX,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)