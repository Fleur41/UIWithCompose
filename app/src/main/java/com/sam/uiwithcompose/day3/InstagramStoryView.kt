package com.sam.uiwithcompose.day3


import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.sam.uiwithcompose.R


//1. A horizontal scrollable list.
//2. Load image in a circular image view.
//3. Add circular, gradient based border around it.
@Composable
fun InstagramStoryView() {
    val  context = LocalContext.current
    val stories = remember {(1..100).toList()}
//    Log.d("TAG", "InstagramStoryView: $stories")

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ){
        items(
            items = stories,
            key = {itemId -> itemId}
        ){itemId ->
            StoryItem(itemId = itemId)
        }

        //For adding more stories
//        itemsIndexed(
//            items = stories,
//            key = {index, itemId -> itemId}
//        ){index, itemId ->
//            StoryItem(itemId = itemId){ itemId ->
//                Toast.makeText(context, "You have clicked on Item: $itemId at index: $index", Toast.LENGTH_SHORT).show()
//            }
//        }
    }
}

@Composable
fun StoryItem(
    modifier: Modifier = Modifier,
    itemId: Int,
    //For story item
//    onStoryClick: (itemId: Int) -> Unit,
) {
    val gradientColors = listOf(Color.Red, Color.Yellow)
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(50.dp)
            .border(
                width = 2.dp,
                brush = Brush.linearGradient(colors = gradientColors),
                shape = CircleShape
            )
            .padding(4.dp)
            .background(Color.LightGray, CircleShape),
//            .clickable { onStoryClick(itemId) },
        contentAlignment = Alignment.Center
    ){
//        Make sure to add coil dependency
//        https://picsum.photos/id/237/200/300
//        https://picsum.photos/id/{id}/200/300
        AsyncImage(
            modifier = Modifier
                .clip(CircleShape)
                .fillMaxSize(),
            model = "https://picsum.photos/id/${itemId}/200/300",
            contentDescription = null,
            contentScale = ContentScale.Crop,
            placeholder =  painterResource( R.drawable.placeholder_image_gray),
            onError = {
                Log.d("TAG", "StoryItem: $itemId result: ${it.result.throwable.message}")
            }
        )
//        Text(text = itemId.toString(), style = MaterialTheme.typography.titleMedium)
    }
}

@Preview
@Composable
private fun StoryItemPreview() {
    StoryItem(itemId = 1)
}
@Preview
@Composable
private fun InstagramStoryViewPreview() {
    InstagramStoryView()

}