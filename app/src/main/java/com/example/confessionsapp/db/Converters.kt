package com.example.confessionsapp.db


import androidx.room.TypeConverter
import com.example.confessionsapp.model.ConfessionCategory
import com.example.confessionsapp.model.ContentStatus
import java.util.Date

class Converters {
    // Date converters
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? = value?.let { Date(it) }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? = date?.time

    // ConfessionCategory converters
    @TypeConverter
    fun toConfessionCategory(value: String): ConfessionCategory =
        enumValueOf<ConfessionCategory>(value)

    @TypeConverter
    fun fromConfessionCategory(category: ConfessionCategory): String =
        category.name

    // ContentStatus converters
    @TypeConverter
    fun toContentStatus(value: String): ContentStatus =
        enumValueOf<ContentStatus>(value)

    @TypeConverter
    fun fromContentStatus(status: ContentStatus): String =
        status.name
}