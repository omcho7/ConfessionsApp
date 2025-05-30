package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "advertisement"
)
data class Advertisement(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val image: String,
    val content: String,
    val url: String,
    val clickCounter: Int = 0
)
