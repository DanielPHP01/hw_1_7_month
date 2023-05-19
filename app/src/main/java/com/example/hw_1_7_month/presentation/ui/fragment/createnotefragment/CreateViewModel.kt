package com.example.hw_1_7_month.presentation.ui.fragment.createnotefragment

import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.domain.usecase.CreateNoteUseCase
import com.example.hw_1_7_month.domain.usecase.EditNoteUseCase
import com.example.hw_1_7_month.domain.utils.UIState
import com.example.hw_1_7_month.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CreateViewModel @Inject constructor (
    private val editNoteUseCase: EditNoteUseCase,
    private val createNoteUseCase: CreateNoteUseCase
): BaseViewModel(){

    private val _createNoteState = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val createNoteState = _createNoteState.asStateFlow()

    private val _editNoteUseCase = MutableStateFlow<UIState<Unit>>(UIState.Empty())
    val editNoteState = _editNoteUseCase.asStateFlow()

    fun createNote(note: Note) {
        createNoteUseCase.createNote(note).collectFlow(_createNoteState)
    }
    fun editNote(note: Note) {
        editNoteUseCase.editNote(note).collectFlow(_editNoteUseCase)

    }

}