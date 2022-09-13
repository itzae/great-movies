package com.itgonca.greatmovies.features.home.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.itgonca.greatmovies.R
import com.itgonca.greatmovies.features.components.tabs.Tab
import com.itgonca.greatmovies.features.components.tabs.TabRowCustom
import com.itgonca.greatmovies.ui.theme.GreatMoviesTheme

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
    ) {
        AppBar()
        TabRowCustom(
            modifier = Modifier.padding(16.dp),
            tabs = listOf(Tab.NowShowing, Tab.ComingSoon)
        )
    }

}

@Composable
fun AppBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(MaterialTheme.colors.background),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.h6.copy(color = MaterialTheme.colors.onBackground)
        )
        IconButton(onClick = { }) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = stringResource(id = R.string.search_button_content_description),
                colorFilter = ColorFilter.tint(color = MaterialTheme.colors.onBackground)
            )
        }
    }
}

@Preview(name = "HomeScreen", showBackground = true)
@Composable
fun HomeScreenPreview() {
    GreatMoviesTheme(darkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) { HomeScreen() }
    }
}

@Preview(name = "AppBar", showBackground = true)
@Composable
fun AppBarPreview() {
    GreatMoviesTheme(darkTheme = false) {
        AppBar()
    }
}
