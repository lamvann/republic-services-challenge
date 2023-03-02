package com.ruiz.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.domain.usecase.GetDriversAndRoutes
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RepublicServicesViewModel(
    app: Application,
) : AndroidViewModel(app), KoinComponent {

    val useCase: GetDriversAndRoutes by inject()

    fun fetch(onSuccess: (DriversAndRoutes) -> Unit) {
        viewModelScope.launch {
            onSuccess(
                useCase(Unit)
            )
        }
    }
}