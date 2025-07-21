package com.sam.uiwithcompose.day1

import android.R.attr.text
import android.media.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
//import com.sam.uiwithcompose.R
//import androidx.compose.foundation.layout.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import com.sam.uiwithcompose.R

@Composable
fun MyFirstComposable(){
    TextField(value = "TextField", onValueChange = {})
    Button(onClick = {}) {
        Text(text = "Click me")
    }
    Text(
        text = "My first text in compose",
        color = Color.Green
    )


}

@Composable
fun ColumnExample() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.End,
        verticalArrangement = Arrangement.Bottom
    )
    {
        Text(
            text = "My first text in compose",
            color = Color.Green
        )
        Button(onClick = {}) {
            Text(text = "Click me")
        }
        TextField(value = "TextField", onValueChange = {})
    }
}

@Composable
fun RowExample() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,

    ){
        Text(
            text = "My first text in compose",
            color = Color.Green
        )
        Button(onClick = {}) {
            Text(text = "Click me")
        }
        TextField(value = "TextField", onValueChange = {})
    }

}

@Composable
fun BoxExample() {
    Box(
        contentAlignment = Alignment.BottomEnd
    ){
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = null
        )
        Icon(imageVector = Icons.Default.Edit, contentDescription = null)
    }
}

//@Preview
//@Composable
//private fun MyFirstComposablePreview() {
//    MyFirstComposable()
//}

//@Preview(showSystemUi = true, device = Devices.PIXEL_4)
//@Composable
//private fun ColumnExamplePreview() {
//    ColumnExample()
//}
//
//@Preview(showSystemUi = true, device = Devices.PIXEL_4)
//@Composable
//private fun RowExamplePreview() {
//    RowExample()
//}

@Preview
@Composable
private fun BoxExamplePreview() {
    BoxExample()
}