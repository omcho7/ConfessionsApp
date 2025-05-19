package com.example.confessionsapp.model

data class Confession(
    val id: Int,
    val category: String,
    val title: String,
    val content: String,
    val timestamp: String,
    val upvotes: Int = 0,
    val downvotes: Int = 0
)