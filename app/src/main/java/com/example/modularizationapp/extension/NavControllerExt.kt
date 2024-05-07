package com.example.modularizationapp.extension

import androidx.navigation.NavController
import com.example.modularizationapp.router.Router

sealed class NavRouterType {
    data object Default : NavRouterType()
    data object CloseCurrentDestination : NavRouterType()
    data object ClearBackStack : NavRouterType()
    data class PopUpTo(
        val router: Router,
        val inclusive: Boolean
    ) : NavRouterType()
}

fun NavController.navigateWithRouter(
    router: Router,
    navRouterType: NavRouterType = NavRouterType.Default,
    isLaunchSingleTop: Boolean = true
) {
    navigate
}