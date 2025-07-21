package com.sam.uiwithcompose.day1

import android.R.attr.text
import android.media.Image
import android.widget.Toast
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
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
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

//@Preview
//@Composable
//private fun MyFirstComposablePreview() {
//    MyFirstComposable()
//}

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

//@Preview(showSystemUi = true, device = Devices.PIXEL_4)
//@Composable
//private fun ColumnExamplePreview() {
//    ColumnExample()
//}

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

//@Preview(showSystemUi = true, device = Devices.PIXEL_4)
//@Composable
//private fun RowExamplePreview() {
//    RowExample()
//}

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
//private fun BoxExamplePreview() {
//    BoxExample()
//}

@Composable
fun ModifierExample(modifier: Modifier = Modifier) {
//    Box(
//        modifier = Modifier
////            .size(100.dp)
//            .height(150.dp)
//            .width(100.dp)
//            .background(Color.Red)
//            .border(width = 5.dp, color = Color.Blue),
//        contentAlignment = Alignment.Center
//    ){
//        val context = LocalContext.current
//        Text(
//            modifier = Modifier.align( Alignment.TopCenter ),
//            fontFamily = FontFamily.SansSerif,
//            text = "Hello"
//        )
//        Text(
//            modifier = Modifier
//                .align(Alignment.Center)
//                .clickable {
//                    Toast.makeText(context, "You have clicked from", Toast.LENGTH_SHORT).show()
//                },
//            fontFamily = FontFamily.Monospace,
//            text = "from")
//
//        Text(
//            modifier = Modifier.align( Alignment.BottomCenter ),
//            fontFamily = FontFamily.Cursive,
//            text = "Engr"
//        )
//    }

//    Box(
//        modifier = Modifier
//            .clip(CircleShape)
////            .clip(RoundedCornerShape(16.dp))
//            .size(100.dp)
//            .background(Color.Red, CircleShape)
//            .border(width = 5.dp, color = Color.Blue, CircleShape),
//        contentAlignment = Alignment.Center
//    ){
//        Text("Circle")
//    }

    Box(
        modifier = Modifier
            .size(100.dp)
            .background(Color.Red)
            .padding(8.dp)
            .border(2.dp, Color.DarkGray),

        contentAlignment = Alignment.Center
    ){
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Green)
                .alpha(1f),
            contentAlignment = Alignment.Center
        ){
            Text("Box")
        }
    }
}

@Preview
@Composable
private fun ModifierExamplePreview() {
    ModifierExample()
}