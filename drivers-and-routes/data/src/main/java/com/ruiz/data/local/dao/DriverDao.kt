package com.ruiz.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.ruiz.data.local.entity.DriverEntity

@Dao
interface DriverDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertDriver(task: DriverEntity)

    @Query("SELECT * FROM driver_table")
    suspend fun getAll(): List<DriverEntity>
}