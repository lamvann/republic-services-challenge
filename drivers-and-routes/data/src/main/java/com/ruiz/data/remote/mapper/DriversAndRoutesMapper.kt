package com.ruiz.data.remote.mapper

import com.ruiz.data.DriversAndRoutesResponse
import com.ruiz.data.Mapper
import com.ruiz.domain.entity.Driver
import com.ruiz.domain.entity.Route
import com.ruiz.domain.entity.DriversAndRoutes

class DriversAndRoutesMapper : Mapper<DriversAndRoutesResponse, DriversAndRoutes>() {
    override fun invoke(from: DriversAndRoutesResponse): DriversAndRoutes {
        return DriversAndRoutes(
            drivers = from.drivers.map {
                Driver(it.id, it.name)
            },
            routes = from.routes.map {
                Route(it.id, it.type, it.name)
            }
        )
    }
}