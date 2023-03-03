package com.ruiz.data.local.mapper

import com.ruiz.domain.entity.Driver
import com.ruiz.data.Mapper
import com.ruiz.data.local.entity.DriverEntity
import com.ruiz.data.local.entity.RouteEntity
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.entity.Route

private typealias DriversAndRoutesEntity = Pair<List<DriverEntity>, List<RouteEntity>>

class DriversAndRouteLocalMapper : Mapper<DriversAndRoutesEntity, DriversAndRoutes>() {
    override fun invoke(from: DriversAndRoutesEntity): DriversAndRoutes {
        return DriversAndRoutes(
            drivers = from.first.map { Driver(id = it.id.toString(), name = it.name) },
            routes = from.second.map { Route(id = it.id, type = it.type, name = it.name) }
        )
    }
}