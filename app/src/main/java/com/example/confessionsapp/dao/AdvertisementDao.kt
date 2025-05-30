package com.example.confessionsapp.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.confessionsapp.model.Advertisement

@Dao
interface AdvertisementDao : BaseDao<Advertisement> {
    @Query("SELECT * FROM advertisement ORDER BY RANDOM() LIMIT 1")
    suspend fun getRandomAdvertisement(): Advertisement?

    @Query("SELECT * FROM advertisement")
    suspend fun getAllAdvertisements(): List<Advertisement>

    @Query("UPDATE advertisement SET clickCounter = clickCounter + 1 WHERE id = :adId")
    suspend fun incrementClickCounter(adId: Int)
}