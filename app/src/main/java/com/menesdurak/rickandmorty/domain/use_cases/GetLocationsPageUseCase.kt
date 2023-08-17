package com.menesdurak.rickandmorty.domain.use_cases

import com.menesdurak.rickandmorty.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class GetLocationsPageUseCase @Inject constructor(
    private val rickAndMortyRepository: RickAndMortyRepository
) {

    suspend operator fun invoke(page: Int) = rickAndMortyRepository.getLocationsPage(page)
}