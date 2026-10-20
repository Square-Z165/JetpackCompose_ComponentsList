package com.example.navigationapplicationandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.navigationapplicationandroid.ui.screens.ComponentListScreen
import com.example.navigationapplicationandroid.ui.screens.DetailScreen
import com.example.navigationapplicationandroid.ui.screens.WelcomeScreen
import com.example.navigationapplicationandroid.ui.theme.NavigationApplicationAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApplicationAndroidTheme {
                var currentScreen by remember { mutableStateOf("welcome") }
                var selectedComponent by remember { mutableStateOf("") }

                when (currentScreen) {
                    "welcome" -> WelcomeScreen(
                        onReadyClick = { currentScreen = "components" },
                        onBackClick = { },
                    )

                    "components" -> ComponentListScreen(
                        onComponentClick = { title ->
                            selectedComponent = title
                            currentScreen = "detail"
                        }
                    )

                    "detail" -> DetailScreen(
                        componentTitle = selectedComponent,
                        onReadyClick = { currentScreen = "components" },
                    )
                }
            }
        }
    }
}
