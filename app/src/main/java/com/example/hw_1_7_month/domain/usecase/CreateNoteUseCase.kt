package com.example.hw_1_7_month.domain.usecase

import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.domain.repositories.NoteRepository

class CreateNoteUseCase(
    private val noteRepository: NoteRepository
) {

    fun createNote(note: Note) = noteRepository.createNote(note)

}