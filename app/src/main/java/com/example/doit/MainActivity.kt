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
