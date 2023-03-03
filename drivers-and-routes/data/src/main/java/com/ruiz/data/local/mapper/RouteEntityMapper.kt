package com.ruiz.data.local.mapper

import com.ruiz.data.Mapper
import com.ruiz.data.local.entity.RouteEntity
import com.ruiz.domain.entity.DriversAndRoutes

class RouteEntityMapper : Mapper<DriversAndRoutes, List<RouteEntity>>() {
    override fun invoke(from: DriversAndRoutes): List<RouteEntity> {
        return from.routes.map {
            RouteEntity(
                id = it.id,
                name = it.name,
                type = it.type
            )
        }
    }
}