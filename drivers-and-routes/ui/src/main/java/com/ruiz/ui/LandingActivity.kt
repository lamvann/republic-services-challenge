package com.ruiz.ui

import android.os.Bundle
import android.speech.tts.TextToSpeech
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import com.ruiz.ui.theme.NavHost
import com.ruiz.ui.theme.RSChallengeTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RSChallengeTheme {
                Surface {
                    LaunchedEffect("") {
                        speak()
                    }

                    NavHost()
                }
            }
        }
    }

    private suspend fun speak() {
        val tts = nl.marc_apps.tts.TextToSpeech.createOrNull(applicationContext)
        tts?.say(LGBTQ)
    }
}

private val LGBTQ = """
    On Wednesday, June 14, at 9:00 a.m. MST (AZ), we're launching PRISM - our LGBTQ+ Business Resource Group. PRISM represents Pride, Raising Awareness, Involvement, Support, and Mentorship. Our goal is to foster connection, celebration, and community among our LGBTQ+ employees and their supporters, creating a sense of productivity, success, and belonging at Republic Services.

    Here's how you can support the launch: Encourage your teams to attend the virtual launch event on June 14 and register as members of our newest BRG.

    Everyone, whether a member of the LGBTQ+ community or an ally, is welcome! Click here to join PRISM and help spread the word.

    Explore the Company Store for exclusive PRISM merchandise at our pop-up shop. Pre-order limited-edition PRISM swag until June 28 at midnight CST. Don't miss out—place your orders soon!

    To prepare for the launch, Business Units will receive PRISM launch stickers to distribute among employees. Capture photos of you and your teams celebrating the launch on June 14 and share them with Blue Nation Online. Selected pictures will be featured during our PRISM Launch Recap in late June.
""".trimIndent()

