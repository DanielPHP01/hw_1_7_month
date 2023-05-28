package com.example.hw_1_7_month.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw_1_7_month.data.model.NoteEntity

@Database(entities = [NoteEntity::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

}