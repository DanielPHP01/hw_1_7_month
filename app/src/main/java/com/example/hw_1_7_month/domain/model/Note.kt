package com.example.hw_1_7_month.domain.model

data class Note(
    val id: Int = DEFAULT_ID,
    val title: String,
    val desc: String,
) {
    companion object {
        const val DEFAULT_ID = 0
    }
}