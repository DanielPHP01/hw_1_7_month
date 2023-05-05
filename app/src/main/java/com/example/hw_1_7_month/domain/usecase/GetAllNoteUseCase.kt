package com.example.hw_1_7_month.domain.usecase

import com.example.hw_1_7_month.domain.repositories.NoteRepository

class GetAllNoteUseCase(
    private val noteRepository: NoteRepository
){
    fun getAllNotes()= noteRepository.getAllNotes()
}