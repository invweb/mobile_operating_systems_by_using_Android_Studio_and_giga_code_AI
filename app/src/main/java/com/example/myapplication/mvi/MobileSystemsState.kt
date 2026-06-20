package com.example.myapplication.mvi

data class MobileSystem(
    val name: String,
    val version: String,
    val url: String,
    val nameResId: Int
)

data class MobileSystemsState(
    val isLoading: Boolean = false,
    val mobileSystems: List<MobileSystem> = emptyList(),
    val error: String? = null
)
