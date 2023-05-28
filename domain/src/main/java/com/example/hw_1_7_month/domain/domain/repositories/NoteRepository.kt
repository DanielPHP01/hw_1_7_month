package com.example.hw_1_7_month.domain.domain.repositories

import com.example.hw_1_7_month.domain.domain.utils.Resource
import com.example.hw_1_7_month.domain.model.Note
import kotlinx.coroutines.flow.Flow


interface NoteRepository {

    fun createNote(note: Note): Flow<Resource<Unit>>

    fun getAllNotes(): Flow<Resource<List<Note>>>

    fun editNote(note: Note): Flow<Resource<Unit>>

    fun removeNote(note: Note): Flow<Resource<Unit>>
}