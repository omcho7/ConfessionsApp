package com.example.confessionsapp.model


import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.confessionsapp.model.User
import java.util.Date

@Entity(
    tableName = "confessions",
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Confession(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val userId: Int,
    val category: ConfessionCategory,
    val body: String? = null,
    val status: ContentStatus = ContentStatus.ACTIVE,
    val createdAt: Date = Date(),
    val upvotes: Int = 0,
    val downvotes: Int = 0
)

enum class ConfessionCategory {
    CONFESSION, DISCUSSION, QUESTION, LOVE, SCHOOL, FAMILY, HUMOR,
    RELATIONSHIP, WORK, FRIENDSHIP, REGRET, ACHIEVEMENT, EMBARRASSING,
    SECRET, OTHER
}

enum class ContentStatus {
    ACTIVE, DELETED, FLAGGED, ARCHIVED
}