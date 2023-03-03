package com.ruiz.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ruiz.ui.screen.DriverScreen
import com.ruiz.ui.RepublicServicesViewModel
import com.ruiz.ui.screen.RouteScreen
import com.ruiz.ui.theme.NavRoutes.HOME
import com.ruiz.ui.theme.NavRoutes.ROUTE_SCREEN
import org.koin.androidx.compose.getViewModel

@Composable
fun FractalNavHost(
    navController: NavHostController = rememberNavController(),
    startDestination: String = HOME,
    viewModel: RepublicServicesViewModel = getViewModel()
) {
    val uiState = viewModel.uiStateLiveData.observeAsState().value!!

    NavHost(navController = navController, startDestination = startDestination) {
        composable(HOME) {
            DriverScreen(
                drivers = uiState.driversAndRoutes.drivers,
                onNavigateToRoute = { driver ->
                    navController.navigate(ROUTE_SCREEN)
                    viewModel.fetchRoutesForDriver(driver)
                }
            )
        }
        composable(ROUTE_SCREEN) {
            RouteScreen(uiState.routeByDriver)
        }
    }
}

object NavRoutes {
    const val HOME = "HOME"
    const val ROUTE_SCREEN = "ROUTE_SCREEN"
}
