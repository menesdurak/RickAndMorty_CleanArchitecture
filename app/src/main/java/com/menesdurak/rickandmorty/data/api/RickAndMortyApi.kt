package com.menesdurak.rickandmorty.data.api

import com.menesdurak.rickandmorty.data.dto.Location
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("location")
    suspend fun getLocationsPage(@Query("page") page: Int): Location
}