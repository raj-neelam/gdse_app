package com.example.doit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Tag_box(tag_name: String){
    Box (
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .border(1.dp, Color.White, RoundedCornerShape(10.dp))
    ){
        Box(modifier = Modifier.background(Color(200,200,200,200), RoundedCornerShape(10.dp))
        ){
            Text(text = tag_name,
                modifier = Modifier.padding(all = 5.dp))
        }
    }
}

@Composable
fun Options_List(uniqueTags: List<String>){
    Box(modifier = Modifier
        .padding(all = 10.dp)
        .fillMaxWidth()){
        Row {
            Icon(painter = painterResource(id = R.drawable.trash__1_),
                contentDescription = "",
                modifier = Modifier.size(30.dp))
            Spacer(modifier = Modifier.width(10.dp))
//                tag_box("All")
            LazyRow {
                items(uniqueTags.size) { index ->
                    Tag_box(uniqueTags[index]) // Display each box in the row
                }
            }
        }
    }
}

fun getUniqueTagsWithAll(data: List<Task>): List<String> {
    val tags = data.map { it.tag }.toSet() // Extract unique tags
    val uniqueTagsWithAll = tags.toMutableSet().apply { add("All") } // Add 'all' tag
    return uniqueTagsWithAll.toList().sortedBy { if (it == "All") -1 else 1 } // Ensure 'all' is at 0th index
}