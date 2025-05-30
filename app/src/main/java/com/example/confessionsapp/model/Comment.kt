package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "comment",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Confession::class, parentColumns = ["id"], childColumns = ["postId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Comment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val userId: Int,
    val postId: Int,
    val upvotes: Int = 0,
    val downvotes: Int = 0,
    val status: String = "active",
    val createdAt: String
)
