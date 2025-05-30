package com.example.confessionsapp.model

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
