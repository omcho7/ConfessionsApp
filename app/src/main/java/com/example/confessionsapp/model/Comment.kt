package com.example.confessionsapp.model

import com.example.confessionsapp.model.Confession
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "comments",
    foreignKeys = [
        ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["userId"], onDelete = ForeignKey.CASCADE),
        ForeignKey(entity = Confession::class, parentColumns = ["id"], childColumns = ["confessionId"], onDelete = ForeignKey.CASCADE)
    ],
)
data class Comment(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val content: String,
    val userId: Int,
    val confessionId: Int,
    val upvotes: Int = 0,
    val downvotes: Int = 0,
    val status: ContentStatus = ContentStatus.ACTIVE,
    val createdAt: Date = Date()
)
