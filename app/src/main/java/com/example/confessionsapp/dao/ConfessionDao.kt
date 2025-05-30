package com.example.confessionsapp.dao

import com.example.confessionsapp.model.Confession
import androidx.room.Dao
import androidx.room.Query
import com.example.confessionsapp.model.ConfessionCategory
import com.example.confessionsapp.model.ContentStatus

@Dao
interface ConfessionDao : BaseDao<Confession> {
    @Query("SELECT * FROM confessions WHERE id = :confessionId")
    suspend fun getConfessionById(confessionId: Int): Confession?

    @Query("SELECT * FROM confessions WHERE userId = :userId")
    suspend fun getConfessionsByUser(userId: Int): List<Confession>

    @Query("SELECT * FROM confessions WHERE category = :category AND status = :status ORDER BY createdAt DESC")
    suspend fun getConfessionsByCategory(category: ConfessionCategory, status: ContentStatus = ContentStatus.ACTIVE): List<Confession>

    @Query("SELECT * FROM confessions WHERE status = :status ORDER BY createdAt DESC")
    suspend fun getAllConfessions(status: ContentStatus = ContentStatus.ACTIVE): List<Confession>

    @Query("UPDATE confessions SET upvotes = upvotes + 1 WHERE id = :confessionId")
    suspend fun incrementUpvotes(confessionId: Int)

    @Query("UPDATE confessions SET downvotes = downvotes + 1 WHERE id = :confessionId")
    suspend fun incrementDownvotes(confessionId: Int)

    @Query("UPDATE confessions SET status = :status WHERE id = :confessionId")
    suspend fun updateStatus(confessionId: Int, status: ContentStatus)
}