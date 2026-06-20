package com.example.myapplication.mvi

import com.example.myapplication.R

object MobileSystemsConfig {
    data class SystemConfig(
        val nameResId: Int,
        val version: String,
        val url: String
    )

    val systems = listOf(
        SystemConfig(nameResId = R.string.android, version = "15", url = "https://www.android.com/"),
        SystemConfig(nameResId = R.string.ios, version = "18", url = "https://www.apple.com/ios/"),
        SystemConfig(nameResId = R.string.harmonyos, version = "5.0", url = "https://www.harmonyos.com/"),
        SystemConfig(nameResId = R.string.windows_mobile, version = "10", url = "https://www.microsoft.com/mobile/"),
        SystemConfig(nameResId = R.string.kaios, version = "3.0", url = "https://www.kaiostech.com/"),
        SystemConfig(nameResId = R.string.blackberry_os, version = "10", url = "https://www.blackberry.com/"),
        SystemConfig(nameResId = R.string.sailfish_os, version = "4.5", url = "https://sailfishos.org/"),
        SystemConfig(nameResId = R.string.tizen, version = "7.0", url = "https://www.tizen.org/")
    )
}
