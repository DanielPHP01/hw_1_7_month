package com.example.hw_1_7_month.presentation.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import com.example.hw_1_7_month.domain.utils.UIState
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.launch

abstract class BaseFragment : Fragment() {
    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        Error: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
       viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect { state ->
                    when (state) {
                        is UIState.Loading -> {
                            onLoading()
                        }
                        is UIState.Error -> {
                            Error(state.message)
                        }
                        is UIState.Success -> {
                            onSuccess(state.data)
                        }
                        is UIState.Empty -> {

                        }
                    }

                }
            }
        }
    }
}