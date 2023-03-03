package com.ruiz.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ruiz.domain.entity.DriversAndRoutes
import com.ruiz.ui.theme.RSChallengeTheme


@Composable
fun DriverScreen(
    apiData: DriversAndRoutes = DriversAndRoutes()
) {
    LazyColumn {
        items(apiData.drivers) {
            Text(text = "Driver: ${it.name}")
        }
        items(apiData.routes) {
            Text(text = "Routes: ${it.name}")
        }
    }
}

@Composable
fun Driver() {
    Card(modifier = Modifier.fillMaxWidth()) {

    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    RSChallengeTheme {
        DriverScreen()
    }
}