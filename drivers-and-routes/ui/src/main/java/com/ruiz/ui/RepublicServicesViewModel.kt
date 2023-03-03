package com.ruiz.ui

import android.app.Application
import com.ruiz.domain.entity.Driver
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.entity.Route
import com.ruiz.domain.usecase.FilterRouteByDriver
import com.ruiz.domain.usecase.GetDriversAndRoutes

class RepublicServicesViewModel(
    app: Application,
    fetchDataUseCase: GetDriversAndRoutes,
    private val filterRoutesUseCase: FilterRouteByDriver
) : BaseViewModel<DriversAndRoutesUiState>(app, DriversAndRoutesUiState()) {

    init {
        executeUseCase(fetchDataUseCase, Unit) {
            updateUiState {
                uiState.copy(
                    driversAndRoutes = it,
                    isLoading = false
                )
            }
        }
    }

    fun fetchRoutesForDriver(driver: Driver) {
        executeUseCase(
            filterRoutesUseCase,
            FilterRouteByDriver.FilterRouteByDriverParams(driver, uiState.driversAndRoutes.routes)
        ) {
            updateUiState {
                uiState.copy(
                    routeByDriver = it
                )
            }
        }
    }

    fun onSortDrivers(ascending: Boolean) = updateUiState {
        val (drivers, routes) = uiState.driversAndRoutes.run { drivers to routes }

        val sortedDrivers = if (ascending)
            drivers.sortedBy { it.name.split(" ").last() }
        else
            drivers.sortedByDescending { it.name.split(" ").last() }

        uiState.copy(
            driversAndRoutes = DriversAndRoutes(drivers = sortedDrivers, routes = routes)
        )
    }
}