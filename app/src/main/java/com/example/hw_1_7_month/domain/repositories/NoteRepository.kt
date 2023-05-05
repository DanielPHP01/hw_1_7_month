package com.example.hw_1_7_month.domain.repositories

import com.example.hw_1_7_month.domain.model.Note


interface NoteRepository {

    fun createNote(noteEntity: Note)

    fun getAllNotes(): List<Note>

    fun editNote(noteEntity: Note)

    fun removeNote(noteEntity: Note)
}