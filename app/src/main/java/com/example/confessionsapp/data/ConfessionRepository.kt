package com.example.confessionsapp.data

import com.example.confessionsapp.model.Confession

object ConfessionRepository {
    val confessions = listOf(
        Confession(
            id = 1,
            category = "Love",
            title = "I miss my ex",
            content = "I still think about my ex every day...",
            timestamp = "May 15, 3:45 PM",
            upvotes = 23,
            downvotes = 4
        ),
        Confession(
            id = 2,
            category = "School",
            title = "Exam confession",
            content = "I cheated on an exam last semester and feel guilty",
            timestamp = "May 16, 10:30 AM",
            upvotes = 6,
            downvotes = 2
        ),
        Confession(
            id = 3,
            category = "Family",
            title = "Dropped out secret",
            content = "My parents still don't know I dropped out of college",
            timestamp = "May 14, 8:15 PM",
            upvotes = 12,
            downvotes = 1
        ),
        Confession(
            id = 4,
            category = "Humor",
            title = "Dog argument",
            content = "I barked back at my dog to win an argument",
            timestamp = "May 16, 2:20 PM",
            upvotes = 34,
            downvotes = 0
        )
    )
}