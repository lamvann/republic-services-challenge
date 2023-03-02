package com.ruiz.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DriversAndRoutesResponse(
    val drivers: List<Driver> = listOf(),
    val routes: List<Route> = listOf()
)

@JsonClass(generateAdapter = true)
data class Driver(
    val id: String = "",
    val name: String = ""
)

@JsonClass(generateAdapter = true)
data class Route(
    val id: Int = 0,
    val type: String = "",
    val name: String = ""
)
