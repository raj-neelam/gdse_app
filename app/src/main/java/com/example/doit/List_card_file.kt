package com.example.doit

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp

@Composable
fun Card_List(data : List<Task>){
    LazyColumn {
        items(data.size + 1) { index ->
            if (index < data.size){
                Card(data[index])
            }else{
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)
                        .padding(top = 10.dp, bottom = 100.dp)
                ) {
                    Text(text = "Created By Raj Gaurav")
                }
            }
        }
    }
}

@Composable
fun Card(task: Task){
    Box (
        modifier = Modifier
            .padding(vertical = 5.dp, horizontal = 10.dp)
            .fillMaxWidth()
            .background(Card_background_col, RoundedCornerShape(10.dp))
            .border(1.dp, Card_border_col, RoundedCornerShape(10.dp))
    ){
        Row (
            verticalAlignment = Alignment.CenterVertically
        ){
            val mark = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
            Checkbox(checked = task.isDone,
                onCheckedChange = {})
            Text(text = task.value,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth(),
                textDecoration = mark
            )
        }
    }
}