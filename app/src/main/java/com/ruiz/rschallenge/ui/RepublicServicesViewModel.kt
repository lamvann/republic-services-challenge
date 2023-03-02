package com.ruiz.rschallenge.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ruiz.rschallenge.data.DriversAndRoutesRepositoryImpl
import com.ruiz.rschallenge.data.DriversAndRoutesResponse
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepublicServicesViewModel(
    app: Application,
) : AndroidViewModel(app), KoinComponent {

    val repository: DriversAndRoutesRepositoryImpl by inject()

    fun fetch(onSuccess: (DriversAndRoutesResponse) -> Unit) {
        viewModelScope.launch {
            onSuccess(
                repository.fetchDriversAndRoutes()
            )
        }
    }
}