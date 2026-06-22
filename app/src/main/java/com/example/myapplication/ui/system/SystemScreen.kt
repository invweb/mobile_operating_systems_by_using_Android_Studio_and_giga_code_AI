package com.example.myapplication.ui.system

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.R
import com.example.myapplication.mvi.MobileSystemsConfig

@Composable
fun SystemDetailScreen(
    systemNameResId: Int,
    modifier: Modifier = Modifier
) {
    val systemInfo = MobileSystemsConfig.systems.firstOrNull { it.nameResId == systemNameResId }
    
    if (systemInfo == null) {
        Text("System not found", modifier = modifier.padding(16.dp))
        return
    }
    
    val descriptionResId = when (systemNameResId) {
        R.string.android -> R.string.description_android
        R.string.ios -> R.string.description_ios
        R.string.harmonyos -> R.string.description_harmonyos
        R.string.windows_mobile -> R.string.description_windows_mobile
        R.string.kaios -> R.string.description_kaios
        R.string.blackberry_os -> R.string.description_blackberry_os
        R.string.sailfish_os -> R.string.description_sailfish_os
        R.string.tizen -> R.string.description_tizen
        else -> R.string.description_android
    }
    
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = stringResource(systemInfo.nameResId),
            fontSize = 32.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        
        Spacer(modifier = Modifier.height(24.dp))
        
        Text(
            text = stringResource(descriptionResId),
            fontSize = 16.sp,
            lineHeight = 24.sp,
            textAlign = TextAlign.Center
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(
            onClick = {
                val context = LocalContext.current
                val intent = android.content.Intent(
                    android.content.Intent.ACTION_VIEW,
                    android.net.Uri.parse(systemInfo.url)
                )
                context.startActivity(intent)
            },
            modifier = Modifier.width(200.dp)
        ) {
            Text(stringResource(R.string.visit_website))
        }
    }
}

@Composable
fun SystemListScreen(
    onSystemSelected: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        item {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = stringResource(R.string.operating_systems),
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        
        items(MobileSystemsConfig.systems) { system ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { onSystemSelected(system.nameResId) },
                elevation = CardDefaults.elevatedCardElevation(4.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = stringResource(system.nameResId),
                            fontSize = 20.sp,
                            fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = stringResource(R.string.version_colon) + " ${system.version}",
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                }
            }
        }
    }
}
