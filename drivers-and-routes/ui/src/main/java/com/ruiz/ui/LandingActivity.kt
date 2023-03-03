package com.ruiz.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.ruiz.ui.theme.NavHost
import com.ruiz.ui.theme.RSChallengeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSChallengeTheme {
                Surface {
                    NavHost()
                }
            }
        }
    }
}

