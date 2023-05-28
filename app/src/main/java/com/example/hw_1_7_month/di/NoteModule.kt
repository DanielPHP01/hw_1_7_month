package com.example.hw_1_7_month.di

import android.content.Context
import androidx.room.Room
import com.example.hw_1_7_month.data.local.NoteDao
import com.example.hw_1_7_month.data.local.NoteDatabase
import com.example.hw_1_7_month.data.repositories.NoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NoteModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        NoteDatabase::class.java,
        "note_db"
    ).build()

    @Provides
    fun provideNoteDao(noteDatabase: NoteDatabase) = noteDatabase.noteDao()

    @Provides
    fun provideNoteRepository(noteDao: NoteDao): NoteRepositoryImpl {
        return NoteRepositoryImpl(noteDao)
    }
}