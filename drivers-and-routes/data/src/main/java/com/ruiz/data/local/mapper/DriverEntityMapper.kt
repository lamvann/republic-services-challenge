package com.ruiz.data.local.mapper

import com.ruiz.data.Mapper
import com.ruiz.data.local.entity.DriverEntity
import com.ruiz.domain.entity.DriversAndRoutes

class DriverEntityMapper : Mapper<DriversAndRoutes, List<DriverEntity>>() {
    override fun invoke(from: DriversAndRoutes): List<DriverEntity> {
        return from.drivers.map {
            DriverEntity(
                id = it.id.toInt(),
                name = it.name
            )
        }
    }
}