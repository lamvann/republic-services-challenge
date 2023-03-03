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
import androidx.compose.ui.unit.dp
import com.ruiz.domain.entity.Route
import com.ruiz.ui.composable.Spacer

@Composable
fun RouteScreen(
    routes: List<Route>
) {
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