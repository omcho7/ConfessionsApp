package com.example.confessionsapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.confessionsapp.model.User

@Dao
interface UserDao : BaseDao<User> {
    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getUserById(userId: Int): User?

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?

    @Query("SELECT * FROM users")
    suspend fun getAllUsers(): List<User>
}