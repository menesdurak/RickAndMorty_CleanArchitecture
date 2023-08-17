package com.menesdurak.rickandmorty.data.source

import com.menesdurak.rickandmorty.common.Resource
import com.menesdurak.rickandmorty.data.dto.Location

interface RemoteDataSource {

    suspend fun getLocationsPage(page: Int): Resource<Location>
}