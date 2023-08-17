package com.menesdurak.rickandmorty.presentation.home

import androidx.annotation.StringRes
import com.menesdurak.rickandmorty.data.dto.Result

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val data: List<Result>) : HomeUiState()
    data class Error(@StringRes val message: Int) : HomeUiState()

}
