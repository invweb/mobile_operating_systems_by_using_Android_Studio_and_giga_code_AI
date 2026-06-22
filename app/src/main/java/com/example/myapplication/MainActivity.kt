package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.system.SystemDetailScreen
import com.example.myapplication.ui.system.SystemListScreen
import com.example.myapplication.ui.theme.MyApplicationTheme

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
            SystemListScreen(
                onSystemSelected = { systemId ->
                    navController.navigate("detail/$systemId")
                },
                navController = navController
            )
        }
        composable(
            "detail/{systemId}",
            arguments = listOf(navArgument("systemId") { type = NavType.IntType })
        ) { entry ->
            val systemId = entry.arguments?.getInt("systemId") ?: R.string.android
            SystemDetailScreen(
                systemNameResId = systemId,
                navController = navController
            )
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
