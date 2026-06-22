package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.myapplication.ui.system.SystemDetailScreen
import com.example.myapplication.ui.system.SystemListScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.core.net.toUri

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                AppNavigation()
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            SystemListScreen(onSystemSelected = { systemId ->
                navController.navigate("detail/$systemId")
            })
        }
        composable(
            "detail/{systemId}",
            arguments = listOf(navArgument("systemId") { type = NavType.IntType })
        ) { entry ->
            val systemId = entry.arguments?.getInt("systemId") ?: R.string.android
            SystemDetailScreen(systemNameResId = systemId)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppNavigationPreview() {
    MyApplicationTheme {
        AppNavigation()
    }
}
