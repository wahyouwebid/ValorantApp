package com.wahyouwebid.valorantapp.features.map.presentation.maps

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.map.domain.GetMapsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MapsViewModel @Inject constructor(
    private val getMapsUseCase: GetMapsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(MapsState())
    val state: State<MapsState> = _state

    init {
        getMaps()
    }

    private fun getMaps() {
        getMapsUseCase().onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = MapsState(isLoading = true)
                is Resource.Success -> _state.value = MapsState(maps = result.data)
                is Resource.Error -> _state.value = MapsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}