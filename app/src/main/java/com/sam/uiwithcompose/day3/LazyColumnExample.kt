package com.sam.uiwithcompose.day3

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color

@Composable
fun ScrollableColumnExample() {
    val list = remember { (1..100).map { "Item $it" } }
    val scrollState = rememberScrollState()
    Column (
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(state = scrollState)
    ){
        list.forEach { item ->
            ListItem(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 8.dp)
                    .fillMaxWidth(),
                item = item
            )

        }
    }
}

@Preview
@Composable
private fun ScrollableColumnExamplePreview() {
    ScrollableColumnExample()
}
@Composable
fun PassComposableExample(
    modifier: Modifier = Modifier,
//    counter: Int,
    onCounterChange: () -> Unit,
    textUi: @Composable () -> Unit
    ) {
    Column (
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        Text(text = "Counter: $counter")
        textUi()
        Button(onClick = { onCounterChange()}) {
            Text(text = "Increment counter")
        }
    }
}

@Composable
fun ParentComposable() {
    var counter by remember { mutableIntStateOf(0) }
    PassComposableExample(
        modifier = Modifier.fillMaxSize(),
//        counter = counter,
        onCounterChange = { counter++ },
        textUi = {
            Card{
                Text(text = "Counter: $counter")
            }
        }
    )
}

@Preview
@Composable
private fun ParentComposablePreview() {
    ParentComposable()
}
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun LazyColumnExample(modifier: Modifier = Modifier) {
    val list = remember { (1..100).map { "Item $it" } }
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
//        item {
//            Text(text = "Header")
//        }

        stickyHeader {
            ListItem(
                modifier = Modifier.fillMaxWidth(),
                item = "Header",
                backgroundColor = Color.Green
            )
        }
        items(items = list){ item ->
            ListItem(
                modifier = Modifier.fillMaxWidth(),
                item = item,

            )
        }

//        items(list.size){ index ->
//            ListItem(
//                modifier = Modifier.fillMaxWidth(),
//                item = list[index]
//            )
//        }

    }
}

@Preview
@Composable
private fun LazyColumnExamplePreview() {
    LazyColumnExample()
}
@Composable
fun ListItem(
    modifier: Modifier = Modifier,
    item: String,
    backgroundColor: Color = Color.Unspecified
) {
    Log.d("TAG", "ListItem: $item")
    
    Card (
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = backgroundColor)
        ){
       Row( modifier = Modifier.padding(8.dp)) {
           Text(text = item, style = MaterialTheme.typography.titleMedium)
       }
    }
}

