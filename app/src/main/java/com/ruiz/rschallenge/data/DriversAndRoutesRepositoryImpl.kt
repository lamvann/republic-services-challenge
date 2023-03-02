package com.ruiz.rschallenge.data

class DriversAndRoutesRepositoryImpl(
    val api: DriversAndRoutesAPI
) {

    suspend fun fetchDriversAndRoutes(): DriversAndRoutesResponse {
        return api.fetchDriversAndRoutes()
    }
}