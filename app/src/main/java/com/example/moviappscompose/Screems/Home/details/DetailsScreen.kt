package com.example.moviappscompose.Screems.Home.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.moviappscompose.model.getMovies
import com.example.moviappscompose.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(navController: NavController, MovieData: String?) {
    val newMovieList = getMovies().filter { movie -> movie.id == MovieData }
    Scaffold(modifier = Modifier.background(color = Color.LightGray),
        topBar = {
            TopAppBar(
                {
                    Row(horizontalArrangement = Arrangement.Start) {
                        Icon(imageVector = Icons.Default.ArrowBack,
                            contentDescription = " botão de Voltar",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            }
                        )
                        Spacer(modifier = Modifier.width(100.dp))
                        Text(text = "movies")
                    }
                })
        }) { contentePadding ->
        Box(modifier = Modifier.padding(contentePadding))
        Surface(
            modifier = Modifier
                .padding(top = 80.dp)
                .fillMaxWidth()
                .fillMaxHeight()

        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {
                MovieRow(Movie = newMovieList.first())
                Text(
                    text = newMovieList[0].title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Divider(thickness = 1.dp)
                LazyRow {
                    items(newMovieList[0].images) { image ->
                        Card(
                            modifier = Modifier
                                .padding(12.dp)
                                .size(200.dp)
                        ) {
                            Image(modifier = Modifier.fillMaxSize(),
                                painter = rememberAsyncImagePainter(
                                    model = image
                                ),
                                contentDescription = "Movie Poster",
                            )
                        }
                    }
                }
            }
        }
    }
}

