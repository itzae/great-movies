package com.itgonca.greatmovies.features.components.tabs

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.itgonca.greatmovies.ui.theme.Gray700
import com.itgonca.greatmovies.ui.theme.GreatMoviesTheme

@Composable
fun TabRowCustom(modifier: Modifier = Modifier, tabs: List<Tab>) {
    var optionSelected by remember {
        mutableStateOf(0)
    }


    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .border(width = 5.dp, color = Gray700, shape = CircleShape)
    ) {
        val tabWidth = maxWidth / tabs.size
        val indicatorOffset: Dp by animateDpAsState(
            targetValue = tabWidth * optionSelected,
            animationSpec = tween(easing = LinearEasing)
        )

        IndicatorCustom(
            indicatorWidth = tabWidth,
            indicatorHeight = 40.dp,
            indicatorOffset
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
            tabs.forEachIndexed { index, tab ->
                TabCustom(
                    text = tab.title,
                    icon = tab.icon,
                    isSelected = optionSelected == index,
                    widthTab = tabWidth
                ) {
                    optionSelected = index
                }
            }
        }
    }
}

@Composable
fun TabCustom(
    modifier: Modifier = Modifier,
    widthTab: Dp,
    text: String,
    icon: Int?,
    isSelected: Boolean,
    onSelected: () -> Unit
) {
    Row(
        modifier = modifier
            .width(widthTab)
            .height(40.dp)
            .clip(CircleShape)
            .clickable { onSelected() },
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if(icon != null && isSelected) {
            Image(
                painter = painterResource(id = icon),
                contentDescription = "Icon tab $text",
                modifier = Modifier.padding(end = 4.dp)
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.caption.copy(color = if (isSelected) Color.White else Color.Gray),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun IndicatorCustom(indicatorWidth: Dp, indicatorHeight: Dp, indicatorOffset: Dp) {
    Box(
        modifier = Modifier
            .offset(x = indicatorOffset)
            .height(indicatorHeight)
            .width(indicatorWidth)
            .background(
                color = Color.Red,
                CircleShape
            )
    )
}

@Preview(name = "TabRowCustomPreview", showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun TabRowCustomPreview() {
    GreatMoviesTheme(darkTheme = true) {
        TabRowCustom(
            tabs = listOf(
                Tab.NowShowing,
                Tab.ComingSoon
            )
        )
    }
}