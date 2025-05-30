package com.example.confessionsapp.model
/* Functionality from this file was moved to Bookmark
import androidx.room.Embedded
import androidx.room.Relation

data class UserWithConfessions(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "userId"
    )
    val confessions: List<Confession>
)
*/