package com.example.sideeffect

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sideeffect.ui.theme.SideeffectTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SideeffectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SideeffectTheme {
        Greeting("Android")
    }
}
@Composable  // LaunchedEffect
fun ExampleScreen_LaunchedEffect() {
    var data by remember { mutableStateOf("") }

    LaunchedEffect(true) {
        // 백그라운드 스레드에서 데이터를 가져옴
        val result = fetchDataFromNetwork()

        // 데이터를 UI에 반영
        data = result
    }
    // UI 렌더링
    Text(text = data)
}
suspend fun fetchDataFromNetwork(): String {
    delay(2000)
    return "Data from netWork"
}

@Composable // SideEffect
fun ExampleScreen_SideEffect() {
    var count by remember { mutableStateOf(0) }

    // count 값을 증가시키는 함수
    fun increaseCount() {
        count++
    }
    // 로깅 함수
    fun logCount() {
        Log.d("ExampleScreen", "count: $count")
    }
    // 버튼 클릭 시 count 값을 증가시키고 로깅함수를 호출
    Button(onClick = {
        increaseCount()
        logCount()
    }){}
}

@Composable
fun ExampleScreen() {
    val countState = remember { mutableStateOf(0) }
    val updateCountState = rememberUpdateState { count ->
        countState.value += count
    }

    // 버튼 클릭 시 count 값을 증가시키는 작업 수행
    Button(onClick = {
        updateCountState(1)
    }) {
        Text(text = "Increment Count")
    }

    // count 값 표시
    Text(text = "Count: ${countState.value}")
}

fun rememberUpdateState(count: String): Int {
    var count = 0
    var countState = 0
}

@Composable
fun ToggleButton() {
    val isChecked = remember { mutableStateOf(false) }
    val state = rememberUpdateState(isChecked.value)

    Box(
        Modifier
            .clip(RoundedCornerShape(50))
            .background(
                if (state.value) Color.Green else Color.Gray,
                RoundedCornerShape(50)
            )
            .clickable(onClick = { state.value = !state.value })
    ) {
        Text(
            text = if (state.value) "On" else "Off",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(8.dp)
        )
    }
}
