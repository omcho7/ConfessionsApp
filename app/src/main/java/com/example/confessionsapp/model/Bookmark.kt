package com.example.confessionsapp.model

import com.example.confessionsapp.model.Confession
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import java.util.Date

@Entity(
    tableName = "bookmark",
    primaryKeys = ["userId", "confessionId"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Confession::class,
            parentColumns = ["id"],
            childColumns = ["confessionId"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [
        Index(value = ["userId"]),
        Index(value = ["confessionId"])
    ]  // Recommended for performance
)
data class Bookmark(
    val userId: Int,
    val confessionId: Int,
    val createdAt: Date = Date()
)
