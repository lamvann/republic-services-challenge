package com.ruiz.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ruiz.domain.entity.Driver
import com.ruiz.ui.composable.Spacer
import com.ruiz.ui.theme.RSChallengeTheme

@Composable
fun DriverScreen(
    drivers: List<Driver> = listOf(),
    onNavigateToRoute: (Driver) -> Unit = {}
) {
    LazyColumn {
        item {
            Text(
                text = "Drivers",
                modifier = Modifier.padding(16.dp),
                fontWeight = FontWeight.SemiBold
            )
        }
        items(drivers) {
            Driver(driver = it, onClick = onNavigateToRoute)
        }
    }
}

@Composable
fun Driver(
    driver: Driver,
    onClick: (Driver) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp)
            .clickable { onClick(driver) }
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Spacer(16.dp)
            Text(
                text = "Name: ${driver.name}"
            )
            Spacer(4.dp)
            Text(
                text = "ID: ${driver.id}",
            )
            Spacer(16.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    RSChallengeTheme {
        DriverScreen()
    }
}