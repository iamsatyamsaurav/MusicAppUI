package com.example.musicappui

import androidx.annotation.DrawableRes

sealed class Screen(val title: String, val route: String) {

    sealed class BottomScreen(val bTitle:String,
                              val bRoute:String,
                              @DrawableRes val icon : Int)
        :Screen(bTitle,bRoute){

            object Home:BottomScreen(
                "Home",
                "home",
                R.drawable.ic_music_player
            )
        object  Library:BottomScreen(
            "Library",
            "library",
            R.drawable.ic_library
        )
        object Browse: BottomScreen(
            "Browse",
            "browse",
            R.drawable.ic_browse
        )
    }

    sealed class DrawerScreen(val dTitle: String,
                              val dRoute: String,
                              @DrawableRes val icon : Int)   //drawable resources are stored in the form of integer
        : Screen(dTitle, dRoute){
//            Several object declarations extend DrawerScreen. These objects represent specific screens within the app, each with a unique title
//            , route, and drawable resource icon.
//          Account: Represents an "Account" screen with the title "Account", route "account", and icon R.drawable.ic_account.

            object Account:DrawerScreen(
                "Account",
                "account",
                R.drawable.ic_account
            )
        object Subscription: DrawerScreen(
            "Subscription",
            "subscribe",
            R.drawable.ic_subscribe

        )
        object AddAccount : DrawerScreen(
            "Add Account",
            "add_account",
            R.drawable.ic_baseline_person_add_alt_1_24
        )
        }
}

val screensInBottom= listOf(
    Screen.BottomScreen.Home,
    Screen.BottomScreen.Browse,
    Screen.BottomScreen.Library
)

val screensInDrawer= listOf(
    Screen.DrawerScreen.Account,
    Screen.DrawerScreen.Subscription,
    Screen.DrawerScreen.AddAccount
)