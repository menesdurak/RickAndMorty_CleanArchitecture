package com.menesdurak.rickandmorty.data.dto

data class Result(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)