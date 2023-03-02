package com.ruiz.domain.entity

data class DriversAndRoutes(
    val drivers: List<Driver> = listOf(),
    val routes: List<Route> = listOf()
)