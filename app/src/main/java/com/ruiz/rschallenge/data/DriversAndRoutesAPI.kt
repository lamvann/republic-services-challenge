package com.ruiz.rschallenge.data

import retrofit2.http.GET

interface DriversAndRoutesAPI {
    @GET("data")
    suspend fun fetchDriversAndRoutes(): DriversAndRoutesResponse
}