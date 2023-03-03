package com.ruiz.data.repository

import androidx.annotation.WorkerThread
import com.ruiz.data.local.dao.DriverDao
import com.ruiz.data.local.dao.RouteDao
import com.ruiz.data.local.mapper.DriverEntityMapper
import com.ruiz.data.local.mapper.DriversAndRouteLocalMapper
import com.ruiz.data.local.mapper.RouteEntityMapper
import com.ruiz.data.remote.api.DriversAndRoutesAPI
import com.ruiz.data.remote.mapper.DriversAndRoutesRemoteMapper
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.repository.DriversAndRoutesRepository

class DriversAndRoutesRepositoryImpl(
    private val api: DriversAndRoutesAPI,
    private val driverDao: DriverDao,
    private val routeDao: RouteDao
) : DriversAndRoutesRepository {

    @WorkerThread
    override suspend fun insertIntoDB(data: DriversAndRoutes) {
        DriverEntityMapper()(data).forEach { driverDao.insertDriver(it) }
        RouteEntityMapper()(data).forEach { routeDao.insertRoute(it) }
    }

    override suspend fun fetchFromDB(): DriversAndRoutes =
        DriversAndRouteLocalMapper()(driverDao.getAll() to routeDao.getAll())

    override suspend fun fetchFromRemote(): DriversAndRoutes =
        DriversAndRoutesRemoteMapper()(api.fetchDriversAndRoutes())

    override suspend fun fetchDriversAndRoutes(): DriversAndRoutes {
        val dbIsEmpty = driverDao.getAll().isEmpty() && routeDao.getAll().isEmpty()

        return if (dbIsEmpty) {
            fetchFromRemote().also { insertIntoDB(it) }
        } else {
            fetchFromDB()
        }
    }
}