package com.example.confessionsapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.confessionsapp.model.Bookmark
import com.example.confessionsapp.model.Confession

@Dao
interface BookmarkDao : BaseDao<Bookmark> {
    @Query("SELECT * FROM bookmark WHERE userId = :userId ORDER BY createdAt DESC")
    suspend fun getBookmarksByUser(userId: Int): List<Bookmark>

    @Query("""
        SELECT c.* FROM confessions c
        INNER JOIN bookmark b ON c.id = b.confessionId
        WHERE b.userId = :userId
        ORDER BY b.createdAt DESC
    """)
    suspend fun getBookmarkedConfessions(userId: Int): List<Confession>

    @Query("SELECT EXISTS(SELECT * FROM bookmark WHERE userId = :userId AND confessionId = :confessionId)")
    suspend fun isBookmarked(userId: Int, confessionId: Int): Boolean

    @Query("DELETE FROM bookmark WHERE userId = :userId AND confessionId = :confessionId")
    suspend fun deleteBookmark(userId: Int, confessionId: Int)
}