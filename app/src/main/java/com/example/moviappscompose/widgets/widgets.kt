package com.example.moviappscompose.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.moviappscompose.model.Movie
import com.example.moviappscompose.model.getMovies


@Preview
@Composable
fun MovieRow(
    Movie: Movie = getMovies()[0],
    onItenClick: (String) -> Unit = {}
) {
    var expanded by remember {
        mutableStateOf(false)

    }
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            //.height(130.dp)
            .clickable {
                onItenClick(Movie.id)
            }
            .shadow(elevation = 6.dp),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Surface(
                modifier = Modifier
                    .padding(12.dp)
                    .size(100.dp),
                shape = RectangleShape,
                shadowElevation = 6.dp
            ) {
                Image(
                    painter = rememberAsyncImagePainter(Movie.images.first()),
                    contentDescription = "Movie Image",
                    contentScale = ContentScale.Crop,
                )
            }
            Column(modifier = Modifier.padding(4.dp)) {
                Text(
                    text = Movie.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text(
                    text = "Director: ${Movie.director}",
                    style = MaterialTheme.typography.bodySmall
                )
                Text(text = "Released: ${Movie.year}")
                AnimatedVisibility(visible = expanded) {
                    Column {
                        Divider(thickness = 1.dp, modifier = Modifier.padding(4.dp))
                        Text(text = "Plot: ${Movie.plot}")
                        Divider(thickness = 1.dp, modifier = Modifier.padding(4.dp))
                        Text(text = "Actors: ${Movie.actors}")
                        Text(text = "Rating: ${Movie.rating}")


                    }
                }
                Icon(
                    imageVector = if (expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                    contentDescription = "",
                    modifier = Modifier
                        .size(25.dp)
                        .clickable { expanded = !expanded },
                    tint = Color.LightGray
                )
            }
        }
    }

}