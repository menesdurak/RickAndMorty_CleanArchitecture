package com.menesdurak.rickandmorty.data.repository

import com.menesdurak.rickandmorty.common.Resource
import com.menesdurak.rickandmorty.data.dto.Location
import com.menesdurak.rickandmorty.data.source.RemoteDataSource
import com.menesdurak.rickandmorty.di.coroutine.IoDispatcher
import com.menesdurak.rickandmorty.domain.repository.RickAndMortyRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
): RickAndMortyRepository {
    override suspend fun getLocationsPage(page: Int): Flow<Resource<Location>> {
        return flow {
            emit(Resource.Loading)
            when (val response = remoteDataSource.getLocationsPage(page)) {
                is Resource.Error -> {
                    emit(Resource.Error(response.exception))
                }
                is Resource.Success -> {
                    emit(Resource.Success(response.result))
                }
                else -> {}
            }
        }.flowOn(ioDispatcher)
    }

}