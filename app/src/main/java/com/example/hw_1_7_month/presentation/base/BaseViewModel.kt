package com.example.hw_1_7_month.presentation.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw_1_7_month.domain.utils.Resource
import com.example.hw_1_7_month.domain.utils.UIState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {
    protected fun <T> Flow<Resource<T>>.collectFlow(_state: MutableStateFlow<UIState<T>>) {
        viewModelScope.launch(Dispatchers.IO) {
            this@collectFlow.collect { result ->
                when (result) {
                    is Resource.Loading -> {
                        _state.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (result.data != null) {
                            _state.value = UIState.Success(result.data)
                        }
                    }
                    is Resource.Error -> {
                        _state.value = UIState.Error(result.message!!)
                    }
                }
            }
        }
    }
}