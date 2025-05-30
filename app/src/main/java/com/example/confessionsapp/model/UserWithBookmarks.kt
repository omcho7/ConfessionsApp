package com.example.confessionsapp.model

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class UserWithBookmarks(
    @Embedded val user: User,
    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = Bookmark::class,
            parentColumn = "userId",
            entityColumn = "postId"
        )
    )
    val bookmarkedPosts: List<Confession>
)
