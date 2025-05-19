package com.example.confessionsapp.data

import com.example.confessionsapp.model.Confession

object ConfessionRepository {
    val confessions = listOf(
        Confession(1, "Love", "I still think about my ex...", mapOf("🥺" to 14, "❤️" to 23)),
        Confession(2, "School", "I cheated on an exam last semester...", mapOf("😬" to 6)),
        Confession(
            3,
            "Family",
            "My parents still don’t know I dropped out...",
            mapOf("😢" to 12, "🤐" to 4)
        ),
        Confession(4, "Humor", "I barked back at my dog to win an argument.", mapOf("😂" to 34)),
        // Add more
    )
}