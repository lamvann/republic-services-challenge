package com.ruiz.drivers_and_routes.di

import com.ruiz.data.remote.api.DriversAndRoutesAPI
import com.ruiz.data.repository.DriversAndRoutesRepositoryImpl
import com.ruiz.domain.repository.DriversAndRoutesRepository
import com.ruiz.domain.usecase.FilterRouteByDriver
import com.ruiz.domain.usecase.GetDriversAndRoutes
import com.ruiz.ui.RepublicServicesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val rsModule = module {
    // Data
    single {
        Retrofit
            .Builder()
            .baseUrl("https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(DriversAndRoutesAPI::class.java) }

    // Domain
    singleOf(::GetDriversAndRoutes)
    singleOf(::FilterRouteByDriver)
    singleOf(::DriversAndRoutesRepositoryImpl) bind DriversAndRoutesRepository::class

    // UI
    viewModelOf(::RepublicServicesViewModel)
}