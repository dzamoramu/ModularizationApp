package com.example.modularizationapp.api

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import java.lang.reflect.Modifier

interface NavigationApi {
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier = Modifier()
    )
}