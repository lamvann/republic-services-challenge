package com.ruiz.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruiz.domain.entity.Driver
import com.ruiz.ui.composable.Spacer
import com.ruiz.ui.theme.Purple500
import com.ruiz.ui.theme.RSChallengeTheme

@Composable
fun DriverScreen(
    drivers: List<Driver> = listOf(),
    onNavigateToRoute: (Driver) -> Unit = {},
    onSortAscending: (Boolean) -> Unit = {}
) {
    Scaffold(
        topBar = {
            RSTopBar(title = "Main Screen", onSort = onSortAscending)
        }
    ) { padding ->
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
}

@Composable
fun RSTopBar(
    title: String,
    onSort: (Boolean) -> Unit
) {
    var sortAscending by rememberSaveable {
        mutableStateOf(true)
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Purple500)
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(2.dp)
        Row {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home", tint = White)
            Spacer(length = 4.dp)
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = White)
        }
        if (sortAscending) {
            Row {
                Text(text = "Sort Ascending", color = White, modifier = Modifier.clickable {
                    onSort(sortAscending)
                    sortAscending = !sortAscending
                })
                Icon(
                    imageVector = Icons.Default.KeyboardArrowUp,
                    contentDescription = "arrow up",
                    tint = Color.White
                )
            }
        } else {
            Row {
                Text(text = "Sort Descending", color = Color.White, modifier = Modifier.clickable {
                    onSort(sortAscending)
                    sortAscending = !sortAscending
                })
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "arrow up",
                    tint = Color.White
                )
            }
        }
        Spacer(8.dp)
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
        Row(verticalAlignment = Alignment.CenterVertically) {
            Spacer(length = 12.dp)
            Icon(
                imageVector = Icons.Default.AccountBox,
                contentDescription = "Account",
                tint = Color.LightGray,
                modifier = Modifier.size(50.dp)
            )
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
}

@Preview(showBackground = true)
@Composable
fun LandingScreenPreview() {
    RSChallengeTheme {
        DriverScreen()
    }
}