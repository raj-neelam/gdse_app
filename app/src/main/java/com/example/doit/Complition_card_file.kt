package com.example.doit

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun Competion_card(){
    Box(modifier = Modifier.padding(all = 20.dp)){
        Column (modifier = Modifier.fillMaxWidth()){
            Text(text = "Your Tasks",
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White)
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
