package com.sam.uiwithcompose.day2

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
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

@Composable
fun ChildComposable(
    modifier: Modifier = Modifier,
    counter: Int,
    onCounterChange: (Int) -> Unit
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
//        var counter by remember { mutableIntStateOf(0) }
//    var counter = 0
        Text(text = "Counter: $counter")
        Button(onClick = { onCounterChange(counter) })
        {
            Text(text = "Increment counter")
        }
    }
}

@Composable
fun IdontCareAboutState(counter: Int) {
    Log.d("TAG", "IdontCareAboutState: ")


}
@Composable
fun ParentComposable(modifier: Modifier = Modifier) {
    var counter by remember { mutableIntStateOf(0) }
    ChildComposable(
        modifier = modifier.fillMaxSize(),
        counter = counter,
        onCounterChange = {
            counter = counter + 2
        }
    )
    IdontCareAboutState(counter)
}

@Preview
@Composable
private fun ParentComposablePreview() {
    ParentComposable()

}