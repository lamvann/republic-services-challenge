package com.ruiz.ui

import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.entity.Route

data class DriversAndRoutesUiState(
    override val isLoading: Boolean = true,
    override val hasError: Boolean = false,

    val driversAndRoutes: DriversAndRoutes = DriversAndRoutes(),
    val routeByDriver: List<Route> = listOf()
) : UiState