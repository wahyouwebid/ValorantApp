package com.wahyouwebid.valorantapp.features.map.presentation.mapdetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahyouwebid.valorantapp.common.Constants
import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.map.domain.GetMapDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MapDetailViewModel @Inject constructor(
    private val getMapDetailUseCase: GetMapDetailUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(MapDetailState())
    val state: State<MapDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MAP_ID)?.let { mapId ->
            getMapDetail(mapId)
        }
    }

    private fun getMapDetail(mapUuid: String) {
        getMapDetailUseCase(mapUuid).onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = MapDetailState(isLoading = true)
                is Resource.Success -> _state.value = MapDetailState(map = result.data)
                is Resource.Error -> _state.value = MapDetailState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}