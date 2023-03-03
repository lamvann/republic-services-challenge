package com.ruiz.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ruiz.data.local.dao.DriverDao
import com.ruiz.data.local.dao.RouteDao
import com.ruiz.data.local.entity.DriverEntity
import com.ruiz.data.local.entity.RouteEntity

@Database(entities = [RouteEntity::class, DriverEntity::class], version = 1, exportSchema = false)
abstract class RSDatabase : RoomDatabase() {
    abstract fun routeDao(): RouteDao
    abstract fun driverDao(): DriverDao

    companion object {
        @Volatile
        private var INSTANCE: RSDatabase? = null

        fun getDatabase(context: Context): RSDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RSDatabase::class.java,
                    "rs_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}