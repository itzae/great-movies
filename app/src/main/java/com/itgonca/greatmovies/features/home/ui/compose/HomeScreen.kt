package com.itgonca.greatmovies.features.home.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.ui.theme.GreatMoviesTheme

@Composable
fun HomeScreen() {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item { AppBar() }
    }
}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Great Movies",
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.onBackground)
        )
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search button",
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
        }
    }
}

@Preview(name = "HomeScreen", showBackground = true)
@Composable
fun HomeScreenPreview() {
    GreatMoviesTheme(darkTheme = true) {
        HomeScreen()
    }
}

@Preview(name = "AppBar", showBackground = true)
@Composable
fun AppBarPreview() {
    GreatMoviesTheme(darkTheme = false) {
        AppBar()
    }
}