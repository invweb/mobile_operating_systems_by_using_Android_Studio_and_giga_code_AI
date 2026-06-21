package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.mvi.MobileSystemsIntent
import com.example.myapplication.mvi.MobileSystemsViewModel
import com.example.myapplication.mvi.MobileSystemsState
import com.example.myapplication.mvi.MobileSystem
import com.example.myapplication.mvi.MobileSystemsConfig
import com.example.myapplication.ui.theme.MyApplicationTheme
import androidx.core.net.toUri

@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = { Text(stringResource(R.string.mobile_systems_title)) },
                            colors = TopAppBarDefaults.topAppBarColors(
                                containerColor = Color(0xFF6750A4),
                                titleContentColor = Color.White
                            )
                        )
                    }
                ) { innerPadding ->
                    val viewModel = remember { MobileSystemsViewModel() }
                    val state by viewModel.state.collectAsState()

                    // Load data on first composition
                    LaunchedEffect(Unit) {
                        viewModel.sendIntent(MobileSystemsIntent.LoadSystems)
                    }

                    MobileSystemsList(
                        state = state,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MobileSystemsList(state: MobileSystemsState, modifier: Modifier = Modifier) {
    if (state.isLoading) {
        CircularProgressIndicator(modifier = modifier)
        return
    }

    if (state.error != null) {
        Text(text = "Ошибка: ${state.error}", modifier = modifier.padding(16.dp))
        return
    }

    LazyColumn(modifier = modifier) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray)
                    .height(48.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.operating_systems),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        items(state.mobileSystems) { system ->
            val context = LocalContext.current
            Text(
                text = "${stringResource(system.nameResId)} ${system.version}",
                modifier = Modifier
                    .padding(16.dp)
                    .clickable {
                        val intent = Intent(Intent.ACTION_VIEW, system.url.toUri())
                        context.startActivity(intent)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MobileSystemsListPreview() {
    MyApplicationTheme {
        MobileSystemsList(
            state = MobileSystemsState(
                isLoading = false,
                mobileSystems = MobileSystemsConfig.systems.map { config ->
                    MobileSystem(
                        name = "",
                        version = config.version,
                        url = config.url,
                        nameResId = config.nameResId
                    )
                }
            )
        )
    }
}
