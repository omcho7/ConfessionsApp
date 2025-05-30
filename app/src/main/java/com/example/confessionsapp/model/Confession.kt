package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "confession")
data class Confession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val category: String,
    val title: String,
    val content: String,
    val timestamp: String,
    val upvotes: Int = 0,
    val downvotes: Int = 0
)