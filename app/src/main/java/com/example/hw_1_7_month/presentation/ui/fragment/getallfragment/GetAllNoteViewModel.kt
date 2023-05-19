package com.example.hw_1_7_month.presentation.ui.fragment.getallfragment

import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.domain.usecase.GetAllNoteUseCase
import com.example.hw_1_7_month.domain.usecase.RemoveNoteUseCase
import com.example.hw_1_7_month.domain.utils.UIState
import com.example.hw_1_7_month.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class GetAllNoteViewModel: BaseViewModel() {
    class FirstViewModel @Inject constructor(
        private val getAllNoteUseCase: GetAllNoteUseCase,
        private val removeNoteUseCase: RemoveNoteUseCase
    ) : BaseViewModel() {


        private val _getAllNotesUseCase = MutableStateFlow<UIState<List<Note>>>(UIState.Empty())
        val getAllNoteState = _getAllNotesUseCase.asStateFlow()


        private val _deleteNoteUseCase = MutableStateFlow<UIState<Unit>>(UIState.Empty())
        val deleteNoteState = _deleteNoteUseCase.asStateFlow()


        fun getAllNotes() {
            getAllNoteUseCase.getAllNotes().collectFlow(_getAllNotesUseCase)
        }

        fun removeNote(note: Note) {
            removeNoteUseCase.removeNote(note).collectFlow(_deleteNoteUseCase)
        }
    }
}