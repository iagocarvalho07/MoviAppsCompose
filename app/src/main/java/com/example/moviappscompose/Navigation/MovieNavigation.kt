package com.example.moviappscompose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.moviappscompose.Screems.Home.details.DetailsScreen
import com.example.moviappscompose.Screems.Home.home.HomeScreen

// 2° criar um componente de nagevação que receba o enum class para facilitar a inserção de novas
// telas

// 3 ° acessar google navgatin compose pegar implementação mais atual e atualizar o gradle
@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {

        // criar o primeiro composable para ser acessado
        composable(MovieScreens.HomeScreen.name) {
            // aqui passamos para onde isso deve nos levar
            HomeScreen(navController = navController)
        }
        composable(
            MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            // aqui passamos para onde isso deve nos levar
            DetailsScreen(
                navController = navController,
                backStackEntry.arguments?.getString("movie")
            )
        }
    }
}