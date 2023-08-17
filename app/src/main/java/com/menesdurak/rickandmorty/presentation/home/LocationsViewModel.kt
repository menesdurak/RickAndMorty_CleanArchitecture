package com.menesdurak.rickandmorty.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.menesdurak.rickandmorty.R
import com.menesdurak.rickandmorty.common.Resource
import com.menesdurak.rickandmorty.domain.use_cases.GetLocationsPageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationsViewModel @Inject constructor(
    private val getLocationsPageUseCase: GetLocationsPageUseCase
): ViewModel() {

    private val _homeUiState = MutableLiveData<HomeUiState>()
    val homeUiState: LiveData<HomeUiState> get() = _homeUiState

    fun getLocationsPage(page: Int) {
        viewModelScope.launch {
            getLocationsPageUseCase(page).collectLatest {
                when (it) {
                    is Resource.Error -> {
                        _homeUiState.postValue(HomeUiState.Error(R.string.error))
                    }
                    Resource.Loading -> {
                        _homeUiState.postValue(HomeUiState.Loading)
                    }
                    is Resource.Success -> {
                        _homeUiState.postValue(HomeUiState.Success(it.result!!))
                    }
                }
            }
        }
    }
}