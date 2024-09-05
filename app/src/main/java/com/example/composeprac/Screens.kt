package com.example.composeprac

sealed class Screens(val Screen: String) {
    data object Home: Screens("Home")
    data object Profile: Screens("Profile")
    data object Setting: Screens("Setting")
    data object Search: Screens("Search")
    data object Post: Screens("Post")
    data object Notification: Screens("Notification")
}