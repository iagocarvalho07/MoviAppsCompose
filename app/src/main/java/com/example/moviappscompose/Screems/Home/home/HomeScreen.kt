package com.example.moviappscompose.Screems.Home.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.moviappscompose.Navigation.MovieScreens
import com.example.moviappscompose.model.Movie
import com.example.moviappscompose.model.getMovies
import com.example.moviappscompose.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Movies") },
            )
        },
    ) { contentPadding ->
        Column {
            Box(modifier = Modifier.padding(contentPadding))
            MainContent(navController = navController)
        }
    }
}


@Composable
fun MainContent(
    navController: NavHostController,
    moviList: List<Movie> = getMovies()
) {
    Column(modifier = Modifier.padding(12.dp)) {
        LazyColumn {
            items(items = moviList) {
                MovieRow(Movie = it) { movie ->
                    navController.navigate(route = MovieScreens.DetailsScreen.name + "/$movie")
                }

            }
        }
    }
}