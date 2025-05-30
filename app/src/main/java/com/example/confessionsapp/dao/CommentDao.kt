package com.example.confessionsapp.dao

import com.example.confessionsapp.model.Confession
import androidx.room.Dao
import androidx.room.Query
import com.example.confessionsapp.model.Comment
import com.example.confessionsapp.model.ContentStatus

@Dao
interface CommentDao : BaseDao<Comment> {
    @Query("SELECT * FROM comments WHERE id = :commentId")
    suspend fun getCommentById(commentId: Int): Comment?

    @Query("SELECT * FROM comments WHERE confessionId = :confessionId AND status = :status ORDER BY createdAt DESC")
    suspend fun getCommentsByConfession(confessionId: Int, status: ContentStatus = ContentStatus.ACTIVE): List<Comment>

    @Query("SELECT * FROM comments WHERE userId = :userId AND status = :status ORDER BY createdAt DESC")
    suspend fun getCommentsByUser(userId: Int, status: ContentStatus = ContentStatus.ACTIVE): List<Comment>

    @Query("UPDATE comments SET upvotes = upvotes + 1 WHERE id = :commentId")
    suspend fun incrementUpvotes(commentId: Int)

    @Query("UPDATE comments SET downvotes = downvotes + 1 WHERE id = :commentId")
    suspend fun incrementDownvotes(commentId: Int)

    @Query("UPDATE comments SET status = :status WHERE id = :commentId")
    suspend fun updateStatus(commentId: Int, status: ContentStatus)
}