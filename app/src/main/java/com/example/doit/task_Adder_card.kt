package com.example.doit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun PopupContent(onDismiss: () -> Unit, onInputSubmit: (String) -> Unit) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(New_Card_form_Glass_col)
        .padding(top = 100.dp, end = 30.dp, start = 30.dp)
    ){
        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f)
            .background(New_task_background_col, RoundedCornerShape(30.dp))
            .padding(all = 20.dp)
        ){
            Column (modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween) {
                Icon(painter = painterResource(id = R.drawable.close),
                    contentDescription = "",
                    Modifier
                        .size(30.dp)
                        .fillMaxWidth()
                        .clickable(onClick = {onDismiss()})
                        .align(Alignment.End),
                    tint = Color.White)
                TextField(value = "",
                    onValueChange = {onInputSubmit(it)},
                    label = { Text(text = "Task...") }
                )
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Tags :")
                    Tag_box(tag_name = "All")
                    Tag_box(tag_name = "Science")
                }
                Text(text = "your Tags")
                Multi_tags_creator(listOf("All", "important", "information", "Math", "Science"))
                Button(onClick = { onDismiss() }
                ) {
                    Text(text = "Create Task")
                }
            }
        }
    }
}
