package com.menesdurak.rickandmorty.di.source

import com.menesdurak.rickandmorty.data.source.RemoteDataSource
import com.menesdurak.rickandmorty.data.source.RemoteDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteDataSource(
        remoteDataSourceImpl: RemoteDataSourceImpl
    ) : RemoteDataSource
}