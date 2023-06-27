package com.example.movieappwithcompose.presentation.movies.views

import androidx.compose.animation.AnimatedContentTransitionScope.SlideDirection.Companion.Start
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.movieappwithcompose.presentation.Screen
import com.example.movieappwithcompose.presentation.movies.MoviesEvent

import com.example.movieappwithcompose.presentation.movies.MoviesViewModel


@Composable
fun MovieScreen(

    navController: NavController,
    viewModel: MoviesViewModel = hiltViewModel()

){

    val state = viewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
        Column {

            SearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, top = 45.dp, end = 10.dp, bottom = 10.dp), hint = "Interstellar", onSearch = {

                viewModel.onEvent(MoviesEvent.Search(it))

            })

            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.movies){
                    MovieListRow(movie = it, onItemClick = {movie->
                       navController.navigate(Screen.DetailsScreen.route + "/${movie.imdbID}" )
                    })
                }
            }


        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(

    modifier: Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}

){
    var text by remember{
        mutableStateOf("")
    }

    var isHintDisplayed by remember {
        mutableStateOf(hint != "")
    }


    Box(modifier = modifier){
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            keyboardActions = KeyboardActions(onDone = {
                onSearch(text)
            }),

            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color =Color.White),
            shape = RoundedCornerShape(10.dp),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.Yellow,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .onFocusChanged {

                    isHintDisplayed = it.isFocused != true && text.isEmpty()

                }
        )

        if (isHintDisplayed){
            Text(text = hint,
            color = Color.LightGray,
            modifier = Modifier.padding(20.dp ,17.dp),

                )
        }

    }

}