package com.example.movieappwithcompose.presentation.movies.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.movieappwithcompose.domain.model.Movie

@OptIn(ExperimentalCoilApi::class)
@Composable
fun MovieListRow(

    movie: Movie,
    onItemClick: (Movie) -> Unit

){
    Row(

        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                onItemClick(movie)
            }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Image(painter = rememberImagePainter(data = movie.Poster ),
            contentDescription = movie.Title,
            modifier = Modifier
                .size(150.dp, 250.dp)
                .clip(RoundedCornerShape(8.dp))
            )

        Column(
            modifier = Modifier.align(CenterVertically).fillMaxWidth(),horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = movie.Title,
                style = MaterialTheme.typography.titleLarge,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.width(IntrinsicSize.Max)

            )



            Text(text = movie.Year,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                color = Color.Yellow,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(15.dp)
            )


        }

    }
}