package com.example.moviappscompose.Navigation

import java.lang.IllegalArgumentException

// 1° primeiro criar um enum class para facilitar a inserção de outras activits que venham a ser criadas conforme o app cresce
enum class MovieScreens {
    HomeScreen,
    DetailsScreen;

    companion object {
        fun fromRoute(route: String?): MovieScreens = when (route?.substringBefore("/")) {
            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("a rota $route não e reconhecida")
        }

    }
}