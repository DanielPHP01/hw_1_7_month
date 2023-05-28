package com.example.hw_1_7_month.domain.domain.usecase

import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.domain.domain.repositories.NoteRepository
import javax.inject.Inject

class RemoveNoteUseCase @Inject constructor(private val noteRepository: NoteRepository) {

    fun removeNote(note:Note) = noteRepository.removeNote(note)
}