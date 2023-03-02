package com.ruiz.domain.repository

import com.ruiz.domain.entity.DriversAndRoutes

interface DriversAndRoutesRepository {
    suspend fun fetchDriversAndRoutes(): DriversAndRoutes
}