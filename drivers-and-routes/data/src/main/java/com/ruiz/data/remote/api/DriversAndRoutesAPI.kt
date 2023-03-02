package com.ruiz.data.remote.api

import com.ruiz.data.DriversAndRoutesResponse
import retrofit2.http.GET

interface DriversAndRoutesAPI {
    @GET("data")
    suspend fun fetchDriversAndRoutes(): DriversAndRoutesResponse
}