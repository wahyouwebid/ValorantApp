package com.wahyouwebid.valorantapp.features.weapon.presentation.weapons

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wahyouwebid.valorantapp.common.Resource
import com.wahyouwebid.valorantapp.features.weapon.domain.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class WeaponsViewModel @Inject constructor(
    private val getWeaponsUseCase: GetWeaponsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(WeaponsState())
    val state: State<WeaponsState> = _state

    init {
        getWeapons()
    }

    private fun getWeapons() {
        getWeaponsUseCase().onEach { result ->
            when (result) {
                Resource.Loading -> _state.value = WeaponsState(isLoading = true)
                is Resource.Success -> _state.value = WeaponsState(weapons = result.data)
                is Resource.Error -> _state.value = WeaponsState(error = result.errorMessage)
            }
        }.launchIn(viewModelScope)
    }
}