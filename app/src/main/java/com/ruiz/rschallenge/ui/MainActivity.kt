package com.ruiz.rschallenge.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ruiz.rschallenge.data.DriversAndRoutesResponse
import com.ruiz.rschallenge.ui.theme.RSChallengeTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    val viewModel: RepublicServicesViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSChallengeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var apiData by remember { mutableStateOf(DriversAndRoutesResponse()) }
                    viewModel.fetch {
                        apiData = it
                    }
                    LandingScreen(apiData)
                }
            }
        }
    }
}

@Composable
fun LandingScreen(
    apiData: DriversAndRoutesResponse = DriversAndRoutesResponse()
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

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    RSChallengeTheme {
        LandingScreen()
    }
}