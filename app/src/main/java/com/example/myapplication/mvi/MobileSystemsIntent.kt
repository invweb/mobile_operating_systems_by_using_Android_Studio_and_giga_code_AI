package com.example.myapplication.mvi

sealed interface MobileSystemsIntent {
    object LoadSystems : MobileSystemsIntent
}
