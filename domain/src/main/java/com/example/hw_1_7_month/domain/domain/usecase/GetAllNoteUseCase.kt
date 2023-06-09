package com.example.hw_1_7_month.domain.domain.usecase

import com.example.hw_1_7_month.domain.domain.repositories.NoteRepository
import javax.inject.Inject

class GetAllNoteUseCase @Inject constructor(
    private val noteRepository: NoteRepository
){
    fun getAllNotes()= noteRepository.getAllNotes()
}