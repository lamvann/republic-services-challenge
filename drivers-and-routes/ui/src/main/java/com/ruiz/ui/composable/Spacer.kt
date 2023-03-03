package com.ruiz.ui.composable

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

@Composable
fun ColumnScope.Spacer(length: Dp) = androidx.compose.foundation.layout.Spacer(
    modifier = Modifier.height(length)
)

@Composable
fun RowScope.Spacer(length: Dp) = androidx.compose.foundation.layout.Spacer(
    modifier = Modifier.width(length)
)