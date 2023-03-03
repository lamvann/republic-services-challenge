package com.ruiz.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ruiz.domain.entity.Route
import com.ruiz.ui.composable.Spacer
import com.ruiz.ui.theme.Purple500

@Composable
fun RouteScreen(
    routes: List<Route>
) {
    Scaffold(topBar = { RSTopBar(title = "Routes Screen")}) { padding ->
        LazyColumn {
            item {
                Text(
                    text = "Routes",
                    modifier = Modifier.padding(16.dp),
                    fontWeight = FontWeight.SemiBold
                )
            }
            items(routes) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 4.dp)
                ) {
                    Column(
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Spacer(16.dp)
                        Text(text = "ID: ${it.id}")
                        Spacer(4.dp)
                        Text(text = "Name: ${it.name}")
                        Spacer(4.dp)
                        Text(text = "Type: ${it.type}")
                        Spacer(16.dp)
                    }
                }
            }
        }
    }
}

@Composable
fun RSTopBar(
    title: String,
) {
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
            Icon(imageVector = Icons.Default.Place, contentDescription = "Home", tint = Color.White)
            Spacer(length = 4.dp)
            Text(text = title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color.White)
        }
        Spacer(8.dp)
    }
}
