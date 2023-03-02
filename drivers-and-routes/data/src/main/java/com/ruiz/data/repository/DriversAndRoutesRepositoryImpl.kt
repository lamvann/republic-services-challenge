package com.ruiz.data.repository

import com.ruiz.data.remote.api.DriversAndRoutesAPI
import com.ruiz.data.remote.mapper.DriversAndRoutesMapper
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.repository.DriversAndRoutesRepository

class DriversAndRoutesRepositoryImpl(
    val api: DriversAndRoutesAPI
) : DriversAndRoutesRepository {

    override suspend fun fetchDriversAndRoutes(): DriversAndRoutes {
        return DriversAndRoutesMapper()(api.fetchDriversAndRoutes())
    }
}