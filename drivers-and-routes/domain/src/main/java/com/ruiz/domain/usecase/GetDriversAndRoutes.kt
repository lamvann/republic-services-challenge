package com.ruiz.domain.usecase

import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.repository.DriversAndRoutesRepository

class GetDriversAndRoutes(
    private val repository: DriversAndRoutesRepository
): UseCase.Async<DriversAndRoutes, Unit> {
    override suspend fun invoke(args: Unit): DriversAndRoutes {
        return repository.fetchDriversAndRoutes()
    }
}