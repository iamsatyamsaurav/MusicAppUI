package com.example.musicappui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MainViewModel:ViewModel() {

    private val _currentScreen : MutableState<Screen> = mutableStateOf(Screen.DrawerScreen.Account)  //this is the default
    val currentScreen : MutableState<Screen>   //exposed variable
        get() = _currentScreen

    fun setCurrentScreen(screen: Screen){
        _currentScreen.value=screen
    }

}