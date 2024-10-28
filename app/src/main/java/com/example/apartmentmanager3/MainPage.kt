package com.example.apartmentmanager3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.apartmentmanager3.ui.theme.ApartmentManager3Theme
import com.example.apartmentmanager3.ui.theme.*
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp

@Composable
fun MainPage(
    modifier: Modifier = Modifier,
    onLogOut: () -> Unit
) {
    var function by rememberSaveable { mutableIntStateOf(0) }
    when (function) {
        0 -> HomePage(modifier, onLogOut)
        1 -> {}
        2 -> {}
        3 -> {}
        4 -> {}
        5 -> {}
        6 -> {}
        7 -> {}
    }

}

@Composable
@OptIn(ExperimentalLayoutApi::class)
private fun HomePage(
    modifier: Modifier,
    onLogOut: () -> Unit
) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background),
    ) {
        item {
            HeaderPane(modifier, screenHeight)
        }

        item {
            FlowRow(
                modifier = Modifier.padding(top = screenWidth * 0.05f)
            ) {
                for (i in 0..6) {
                    ApartmentInfoCard()
                }

            }

        }
    }
}

@Composable
private fun ApartmentInfoCard() {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val cardPadding = screenWidth * 0.05f
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        modifier = Modifier
            .padding(cardPadding)
            .width(screenWidth * 0.4f)
            .height(screenWidth * 0.4f),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        ),

    ) {
        Row {
            Column {

            }

        }
    }
}

@Composable
private fun HeaderPane(
    modifier: Modifier,
    screenHeight: Dp
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight * 0.4f),
        color = MaterialTheme.colorScheme.primary
    ) {
        Text("Hello, User")
    }
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview(){
    ApartmentManager3Theme {
        MainPage(modifier = Modifier, onLogOut = {})
    }
}
