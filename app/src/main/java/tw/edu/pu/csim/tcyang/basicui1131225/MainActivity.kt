package tw.edu.pu.csim.tcyang.basicui1131225

import android.R.attr.text
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp // <-- 確保有這個 import
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.tcyang.basicui1131225.ui.theme.BasicUI1131225Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicUI1131225Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Main(
                        // 將 Scaffold 的邊距傳遞給 Main  composable
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Main(modifier: Modifier = Modifier) {
    var Animals = listOf(
        R.drawable.animal0, R.drawable.animal1,
        R.drawable.animal2, R.drawable.animal3,
        R.drawable.animal4, R.drawable.animal5,
        R.drawable.animal6, R.drawable.animal7,
        R.drawable.animal8, R.drawable.animal9
    )
    var AnimalsName = arrayListOf("鴨子","企鵝",
        "青蛙","貓頭鷹","海豚", "牛", "無尾熊", "獅子", "狐狸", "小雞")


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0x8aE0BBE4)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = stringResource(R.string.app_title),
            fontSize = 25.sp,
            color = Color.Blue,
            fontFamily = FontFamily(Font(R.font.kai))
        )
        Text(
            text = stringResource(R.string.app_author),
            fontSize = 20.sp,
            color = Color(0xFF654321)
        )

        Spacer(modifier = Modifier.size(10.dp))
        Row {
            Image(
                painter = painterResource(id = R.drawable.android),
                contentDescription = "Android icon",
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Yellow),
                alpha = 0.6f,
            )
            Image(
                painter = painterResource(id = R.drawable.compose),
                contentDescription = "Compose icon",
                modifier = Modifier.size(100.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.firebase),
                contentDescription = "Firebase icon",
                modifier = Modifier.size(100.dp)
            )
        }
        LazyRow {
            items(51) { index ->
                Text(text = AnimalsName[index % 10])
                Text(text = "$index")
                Image(
                    painter = painterResource(id = Animals[index % 10]),
                    contentDescription = "可愛動物圖片",
                    modifier = Modifier.size(60.dp)
                )
                Spacer(modifier = Modifier.size(10.dp))
            }
        }

        Spacer(modifier = Modifier.size(10.dp))

        }
        for (i in 0..51) {
            Text(text = i.toString())
        }
    }


