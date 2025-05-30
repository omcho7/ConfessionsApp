package com.example.confessionsapp.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.Date

@Entity(
    tableName = "users",
    indices = [
        Index("username", unique = true)
    ]
)
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val username: String,
    val passwordHash: String,
    val role: String,
    val dailyStreak: Int = 0,
    val createdAt: Date = Date()
) {
    init {
        require(username.length in 3..20) { "Username must be 3-20 characters" }
        require(passwordHash.length == 64) { "Password hash must be SHA-256" }
    }
}

