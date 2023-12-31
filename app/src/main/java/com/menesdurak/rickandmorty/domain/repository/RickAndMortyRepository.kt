package com.menesdurak.rickandmorty.domain.repository

import com.menesdurak.rickandmorty.common.Resource
import com.menesdurak.rickandmorty.data.dto.Result
import kotlinx.coroutines.flow.Flow

interface RickAndMortyRepository {
    suspend fun getLocationsPage(page: Int) : Flow<Resource<List<Result>>>
}