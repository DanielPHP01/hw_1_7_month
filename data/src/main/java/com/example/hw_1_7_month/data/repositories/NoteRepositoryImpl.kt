package com.example.hw_1_7_month.data.repositories

import com.example.hw_1_7_month.data.base.BaseRepository
import com.example.hw_1_7_month.data.local.NoteDao
import com.example.hw_1_7_month.data.mappers.toEntity
import com.example.hw_1_7_month.data.mappers.toNote
import com.example.hw_1_7_month.domain.domain.repositories.NoteRepository
import com.example.hw_1_7_month.domain.model.Note
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDao: NoteDao,
) : NoteRepository,BaseRepository(){
    override fun createNote(note: Note) = doRequest {
       noteDao.createNote(note.toEntity())
    }

    override fun getAllNotes() = doRequest{
        noteDao.getAllNotes().map { it.toNote() }
    }

    override fun editNote(note: Note) = doRequest {
       noteDao.editNote(note.toEntity())
    }

    override fun removeNote(note: Note) = doRequest {
       noteDao.removeNote(note.toEntity())
    }

}