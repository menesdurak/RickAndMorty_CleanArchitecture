package com.menesdurak.rickandmorty.data.source

import com.menesdurak.rickandmorty.common.Resource
import com.menesdurak.rickandmorty.data.api.RickAndMortyApi
import com.menesdurak.rickandmorty.data.dto.Location
import java.lang.Exception
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val rickAndMortyApi: RickAndMortyApi,
) : RemoteDataSource {
    override suspend fun getLocationsPage(page: Int): Resource<Location> = try {
        val response = rickAndMortyApi.getLocationsPage(page)
        Resource.Success(response)
    } catch (e: Exception) {
        println(e)
        Resource.Error(e)
    }
}