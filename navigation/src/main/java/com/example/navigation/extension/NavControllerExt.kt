package com.example.navigation.extension

import androidx.navigation.NavController
import com.example.navigation.router.Router

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
    navRouterType: NavRouterType = com.example.navigation.extension.NavRouterType.Default,
    isLaunchSingleTop: Boolean = true
) {

}