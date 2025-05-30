package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "confession",
    foreignKeys = [ForeignKey(
        entity = User::class,
        parentColumns = ["id"],
        childColumns = ["userId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Confession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val userId: Int,
    val category: String,
    val title: String,
    val content: String,
    val status: String = "active",
    val createdAt: String,
    val upvotes: Int = 0,
    val downvotes: Int = 0
)
