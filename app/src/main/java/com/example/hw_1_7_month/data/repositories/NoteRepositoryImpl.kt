package com.example.hw_1_7_month.data.repositories

import com.example.hw_1_7_month.data.local.NoteDao
import com.example.hw_1_7_month.domain.model.Note
import com.example.hw_1_7_month.domain.repositories.NoteRepository

class NoteRepositoryImpl(
    private val noteDao: NoteDao,
) : NoteRepository {

    override fun createNote(note: Note) {
        noteDao.createNote(note)
    }

    override fun getAllNotes(): List<Note> {
        return noteDao.getAllNotes()
    }

    override fun editNote(note: Note) {
    }

    override fun removeNote(note: Note) {
    }
}