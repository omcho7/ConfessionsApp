package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "bookmark",
    primaryKeys = ["userId", "postId"],
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Confession::class, parentColumns = ["id"], childColumns = ["postId"], onDelete = ForeignKey.CASCADE)
    ]
)
data class Bookmark(
    val userId: Int,
    val postId: Int
)
