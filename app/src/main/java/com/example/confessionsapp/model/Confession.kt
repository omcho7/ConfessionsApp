package com.example.confessionsapp.model

data class Confession(
    val id: Int,
    val category: String,
    val content: String,
    val reactions: Map<String, Int>
)