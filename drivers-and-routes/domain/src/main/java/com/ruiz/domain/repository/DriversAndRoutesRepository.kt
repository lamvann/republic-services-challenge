package com.ruiz.domain.repository

import com.ruiz.domain.entity.DriversAndRoutes

interface DriversAndRoutesRepository {
    suspend fun insertIntoDB(data: DriversAndRoutes)
    suspend fun fetchFromDB(): DriversAndRoutes
    suspend fun fetchFromRemote(): DriversAndRoutes
    suspend fun fetchDriversAndRoutes(): DriversAndRoutes
}