package com.example.doit

import android.content.ClipData.Item
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Brush
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.doit.ui.theme.DoItTheme

val background_col = listOf(Color(0xFF8000F0),Color(0xFF800080), Color(0xFFFFA500))
val Progress_card_col = Color(250,250,250,150)
val Done_progress_col = Color(200,255,200,200)
val Remaining_Progress_col = Color(135,135,135,255)
val Card_background_col = Color(200,200,200,150)
val Card_border_col = Color.White

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var data = listOf(Task("None", false, "this is first"),
                Task("None", false, "this is first"),
                Task("Important", true, "this is second"),
                Task("None", false, "and this one is the last one ok"),
                Task("Important", true, "what do you think about this one it is the best one"),
                Task("Very_big_one", false, "this would be the long string and its gona strech beyond any belive so priny it wisely and clearly so that i can unmark and then mark it back to the stack and horse"),
                Task("Math", true, "this is last"),
                Task("Science", true, "this is this one is the big one"),
                Task("Comerse", true, "and this is not that special as it comes form my house and need some assistance"),
                Task("Science", true, "this is this one is the big one what do you think about this one"),
                )
            val gradient = Brush.linearGradient(
                colors = background_col,
                start = Offset.Companion.Zero,
                end = Offset.Infinite
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient)){
                Column {
                    Competion_card()
                    Options_List(getUniqueTagsWithAll(data))
                    Card_List(data)
                }
            }
        }
    }
}

class Task(var tag: String, var isDone: Boolean, var value: String)

@Preview
@Composable
fun Competion_card(){
    Box(modifier = Modifier.padding(all = 20.dp)){
        Column (modifier = Modifier.fillMaxWidth()){
            Text(text = "Your Tasks",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.White, RoundedCornerShape(10.dp))
                .background(Progress_card_col, shape = RoundedCornerShape(10.dp))
            ){
                Row (verticalAlignment = Alignment.CenterVertically,
//                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .padding(start = 20.dp, top = 20.dp, bottom = 20.dp)
                        .fillMaxWidth()){
                    Column (){
                        Text(text = "you have compleated", modifier = Modifier
                            .fillMaxWidth(0.6f)
                            .padding(bottom = 10.dp),
                            fontSize = 20.sp)
                        Text(text = "${61.2f}%  ", fontSize = 30.sp,
                            modifier = Modifier.fillMaxWidth(0.45f),
                            textAlign = TextAlign.End)
                        Text(text = "of all your tasks", modifier = Modifier
                            .fillMaxWidth(0.45f)
                            .padding(top = 10.dp),
                            fontSize = 20.sp)
                    }
                    Row(modifier = Modifier
                        .padding(end = 20.dp)
                        .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center){
                        Box(modifier = Modifier.padding(top = 20.dp)){
                            CircularProgressIndicator(progress = 0.65f,
                                modifier = Modifier
                                    .height(120.dp)
                                    .width(120.dp),
                                strokeCap = StrokeCap.Round,
                                trackColor = Remaining_Progress_col,
                                strokeWidth = 15.dp,
                                color = Done_progress_col
                            )
                        }
                    }
                }
            }
        }
    }
}

fun calculateCompletionRate(tasks: List<Task>): Float {
    if (tasks.isEmpty()) return 0f // Return 0 if the list is empty
    val doneTasksCount = tasks.count { it.isDone }
    return doneTasksCount.toFloat() / tasks.size.toFloat()
}

@Composable
fun tag_box(tag_name: String){
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
                        tag_box(uniqueTags[index]) // Display each box in the row
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
            val img =  if (task.isDone) R.drawable.square__2_ else R.drawable.stop
            val mark = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
            Image(painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier
                    .padding(all = 10.dp)
                    .size(20.dp)
            )
            Text(text = task.value,
                modifier = Modifier
                    .padding(all = 10.dp)
                    .fillMaxWidth(),
                textDecoration = mark
                )
//            CircularProgressIndicator()
        }
    }
}