package com.example.hw_1_7_month.presentation.base

import androidx.fragment.app.Fragment
import com.example.hw_1_7_month.domain.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

abstract class BaseFragment:Fragment() {
    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message:String) -> Unit,
        onSuccess: (data:T) -> Unit
    ) {
        lifecycleScope.launch {

        }
    }
}