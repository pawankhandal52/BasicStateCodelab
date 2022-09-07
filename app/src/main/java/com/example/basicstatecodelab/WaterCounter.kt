package com.example.basicstatecodelab

import WellnessTaskItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCount(modifier: Modifier = Modifier){
    var count by  rememberSaveable { mutableStateOf(0) }

    Column(modifier = modifier.padding(16.dp)) {
        if(count>0){
            /*var showTask by remember {
                mutableStateOf(true)
            }
            if(showTask){
                WellnessTaskItem(
                    onClose = { showTask = false},
                    taskName = "Have you taken your 15 minute walk today?"
                )
            }*/
            Text(text ="You have $count glasses")
        }
        Button(onClick = { count++ },
            modifier = modifier,
            enabled = count<10
        ) {
            Text(text = "Add One")
        }
        /*Row(modifier = modifier.padding(top = 8.dp)) {

            Button(onClick = { count=0 }, modifier = modifier.padding(start = 8.dp)) {
                Text(text = "Clear Water Count")
            }
        }*/

    }
    
}

@Composable
fun StatelessCounter(count:Int,onIncrement:()->Unit,modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0) {
            Text("You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text("Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Preview(name = "Water Count", showBackground = true, widthDp = 360, heightDp = 500)
@Composable
fun WaterCountPreview(){
    WaterCount()
}
