package com.ruiz.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.IGNORE
import androidx.room.Query
import com.ruiz.data.local.entity.RouteEntity

@Dao
interface RouteDao {
    @Insert(onConflict = IGNORE)
    suspend fun insertRoute(route: RouteEntity)

    @Query("SELECT * FROM route_table")
    suspend fun getAll(): List<RouteEntity>
}