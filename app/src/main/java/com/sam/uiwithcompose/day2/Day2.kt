package com.sam.uiwithcompose.day2

import android.text.Layout
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CompositionExample() {
    var counter by remember { mutableIntStateOf(0) }
//    var counter = 0
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Counter: $counter")
        Button(onClick = {
            counter++
            Log.d("TAG", "counter: $counter")
            
        }) {
            Text(text = "Click to increment counter")
        }
    }
}

@Composable
fun TextFieldExample() {
    var text by remember { mutableStateOf("") }
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        TextField(
            value = text,
            onValueChange = { updatedValue ->
                Log.d("TAG", "updatedValue: $updatedValue")
                text = updatedValue
            },
            supportingText = {Text("Please input some text here..")},
            colors = TextFieldDefaults.colors(
//                focusedTextColor = Color.DarkGray, // Color of the input text when focused
//                focusedContainerColor = Color.Transparent, // Background when focused
                focusedLabelColor = Color.Green,
            )
        )

    }
}

@Preview
@Composable
private fun CompositionExamplePreview() {
    CompositionExample()
}

@Preview
@Composable
private fun TextFieldExamplePreview() {
    TextFieldExample()
}