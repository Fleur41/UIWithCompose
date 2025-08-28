package com.sam.uiwithcompose.day2

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun EffectExample(
    modifier: Modifier = Modifier,

) {
    var counter1 by remember { mutableIntStateOf(0) }
    var counter2 by remember { mutableIntStateOf(0) }
    var counter3 by remember { mutableIntStateOf(0) }

    Log.d("TAG", "This is printed from Compose Land")
    SideEffect {
        Log.d("TAG", "This is printed from SideEffect")

    }
    LaunchedEffect(counter2, counter3) {
        Log.d("TAG", "This should be printed only when counter 2 OR 3 changes.")
    }

    LaunchedEffect(Unit) {
        Log.d("TAG", "This should be printed only once.")

    }

//    DisposableEffect(Unit) {
//        Log.d("TAG", "This should be printed only once.")
//        onDispose {
//
//        }
//
//    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {


        Text(text = "Counter1: $counter1")
        Text(text = "Counter2: $counter2")
        Text(text = "Counter3: $counter3")

//        if (counter2 % 2 == 0) {
//            DisposableEffectExample(counter = counter2)
//        }
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


@Composable
fun DisposableEffectExample(counter: Int) {
    var localCounter by remember { mutableIntStateOf(0) }
    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Disposable counter: $localCounter")
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { localCounter++ }) {
                Text(text = "Increment local counter")
            }
        }
    }
//    Text(text = "Disposable counter: $counter")
    DisposableEffect(counter,localCounter) {
        Log.d("TAG", "DisposableEffect counter: $localCounter")
        onDispose {
            Log.d("TAG", "Key is disposed")

        }

    }
}
@Preview
@Composable
private fun EffectExamplePreview() {
    EffectExample()
}

fun main() {
    try {

    } catch (e: Exception) {

    } finally {

    }
}