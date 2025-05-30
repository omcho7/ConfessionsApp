package com.example.confessionsapp.data


import java.util.Date
import com.example.confessionsapp.model.Confession
import com.example.confessionsapp.model.ConfessionCategory
import com.example.confessionsapp.model.ContentStatus


object ConfessionRepository {
    val confessions = listOf(
        Confession(
            id = 1,
            title = "I miss my ex",
            userId = 1, // Added required userId
            category = ConfessionCategory.LOVE, // Changed to enum
            body = "I still think about my ex every day...", // Changed from content to body
            status = ContentStatus.ACTIVE, // Added required status
            createdAt = Date(), // Changed from timestamp to createdAt
            upvotes = 23,
            downvotes = 4
        ),
        Confession(
            id = 2,
            title = "Exam confession",
            userId = 1,
            category = ConfessionCategory.SCHOOL,
            body = "I cheated on an exam last semester and feel guilty",
            status = ContentStatus.ACTIVE,
            createdAt = Date(),
            upvotes = 6,
            downvotes = 2
        ),
        Confession(
            id = 3,
            title = "Dropped out secret",
            userId = 1,
            category = ConfessionCategory.FAMILY,
            body = "My parents still don't know I dropped out of college",
            status = ContentStatus.ACTIVE,
            createdAt = Date(),
            upvotes = 12,
            downvotes = 1
        ),
        Confession(
            id = 4,
            title = "Dog argument",
            userId = 1,
            category = ConfessionCategory.HUMOR,
            body = "I barked back at my dog to win an argument",
            status = ContentStatus.ACTIVE,
            createdAt = Date(),
            upvotes = 34,
            downvotes = 0
        )
    )
}