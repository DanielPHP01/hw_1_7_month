package com.example.hw_1_7_month.data.mappers

import com.example.hw_1_7_month.data.model.NoteEntity
import com.example.hw_1_7_month.domain.model.Note

fun Note.toEntity() = NoteEntity(id, title, desc)

fun NoteEntity.toNote() = Note(id, title, desc)