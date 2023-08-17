package com.menesdurak.rickandmorty.data.mapper

import com.menesdurak.rickandmorty.common.ListMapper
import com.menesdurak.rickandmorty.data.dto.Result
import com.menesdurak.rickandmorty.domain.model.LocationUiData

class LocationUiDataMapper: ListMapper<Result, LocationUiData> {
    override fun map(input: List<Result>): List<LocationUiData> {
        return input.map {
            LocationUiData(
                id = it.id,
                name = it.name
            )
        }
    }
}