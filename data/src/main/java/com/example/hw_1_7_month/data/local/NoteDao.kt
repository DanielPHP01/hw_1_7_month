package com.example.hw_1_7_month.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.hw_1_7_month.data.model.NoteEntity

@Dao
interface NoteDao {
    @Insert
    suspend fun createNote(noteEntity: NoteEntity)

    @Query("SELECT * FROM notes")
    suspend fun getAllNotes(): List<NoteEntity>

    @Update
    suspend fun editNote(noteEntity: NoteEntity)

    @Delete
    suspend fun removeNote(noteEntity: NoteEntity)

}