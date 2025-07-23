package com.sam.uiwithcompose.day2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun EffectExample(
    modifier: Modifier = Modifier,

) {
    var counter1 by remember { mutableIntStateOf(0) }
    var counter2 by remember { mutableIntStateOf(0) }
    var counter3 by remember { mutableIntStateOf(0) }

    LaunchedEffect(key1 = counter2) {
        Log.d("TAG", "This should be printed only when counter 2 OR 3 changes.")
        
    }
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "Counter1: $counter1")
        Text(text = "Counter2: $counter2")
        Text(text = "Counter3: $counter3")
        Button(onClick = {
            counter1++
            if (counter1 % 2 == 0) counter2++
            if (counter1 % 3 == 0) counter3++
            }
        ) {
            Text(text = "Increment counter")
        }
    }
}

@Preview
@Composable
private fun EffectExamplePreview() {
    EffectExample()
}