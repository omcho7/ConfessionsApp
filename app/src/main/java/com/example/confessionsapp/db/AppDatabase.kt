package com.example.confessionsapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.confessionsapp.dao.AdvertisementDao
import com.example.confessionsapp.dao.BookmarkDao
import com.example.confessionsapp.dao.CommentDao
import com.example.confessionsapp.dao.ConfessionDao
import com.example.confessionsapp.dao.UserDao
import com.example.confessionsapp.model.*



@Database(
    entities = [
        User::class,
        Confession::class,
        Comment::class,
        Advertisement::class,
        Bookmark::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun confessionDao(): ConfessionDao
    abstract fun commentDao(): CommentDao
    abstract fun advertisementDao(): AdvertisementDao
    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "confessions_db"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}