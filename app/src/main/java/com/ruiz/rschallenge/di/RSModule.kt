package com.ruiz.rschallenge.di

import com.ruiz.rschallenge.data.DriversAndRoutesAPI
import com.ruiz.rschallenge.data.DriversAndRoutesRepositoryImpl
import com.ruiz.rschallenge.ui.RepublicServicesViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val rsModule = module {
    single {
        Retrofit
            .Builder()
            .baseUrl("https://d49c3a78-a4f2-437d-bf72-569334dea17c.mock.pstmn.io/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }
    single { get<Retrofit>().create(DriversAndRoutesAPI::class.java) }
    singleOf(::DriversAndRoutesRepositoryImpl)
    viewModelOf(::RepublicServicesViewModel)
}