package com.menesdurak.rickandmorty.di.repository

import com.menesdurak.rickandmorty.data.repository.RickAndMortyRepositoryImpl
import com.menesdurak.rickandmorty.domain.repository.RickAndMortyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RickAndMortyRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRickAndMortyRepository(
        rickAndMortyImpl: RickAndMortyRepositoryImpl
    ): RickAndMortyRepository
}