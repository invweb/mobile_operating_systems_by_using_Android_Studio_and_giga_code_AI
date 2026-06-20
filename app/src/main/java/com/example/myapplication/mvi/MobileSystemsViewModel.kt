package com.example.myapplication.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MobileSystemsViewModel : ViewModel() {

    private val _state = MutableStateFlow(MobileSystemsState())
    val state: StateFlow<MobileSystemsState> = _state

    fun sendIntent(intent: MobileSystemsIntent) {
        when (intent) {
            is MobileSystemsIntent.LoadSystems -> loadMobileSystems()
        }
    }

    private fun loadMobileSystems() {
        _state.value = _state.value.copy(isLoading = true)

        viewModelScope.launch {
            try {
                val systems = MobileSystemsConfig.systems.map { config ->
                    MobileSystem(
                        name = "",
                        version = config.version,
                        url = config.url,
                        nameResId = config.nameResId
                    )
                }
                _state.value = _state.value.copy(
                    isLoading = false,
                    mobileSystems = systems,
                    error = null
                )
            } catch (e: Exception) {
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}
