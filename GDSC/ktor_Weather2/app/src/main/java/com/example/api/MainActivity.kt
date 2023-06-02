package com.example.api

import android.net.http.HttpResponseCache.install
import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.api.ui.theme.ApiTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

// buld Weather app with Jetpack Compose and ktor
// using api key https://api.openweathermap.org/data/2.5/weather?lat=44.34&lon=10.99&appid=

class MainActivity : AppCompatActivity() {

    private lateinit var weatherTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        weatherTextView = findViewById(R.id.weatherTextView)

        // API 호출
        getWeatherData("Seoul")
    }

    private fun getWeatherData(city: String) {
        val apiKey = "142040a9bbf97e6ee6ed7ab6540fb6a4"
        val url = "http://api.openweathermap.org/data/2.5/weather?q=$city&appid=$apiKey"

        val httpClient = HttpClient(Android) {
            install(JsonFeature)
        }

        // 비동기로 API 호출
        lifecycleScope.launch {
            val response = httpClient.get<WeatherResponse>(url)
            showWeatherData(response)
        }
    }

    private suspend fun showWeatherData(weatherResponse: WeatherResponse) {
        withContext(Dispatchers.Main) {
            val temperature = weatherResponse.main.temp
            val description = weatherResponse.weather[0].description

            val weatherText = "Temperature: $temperature\nDescription: $description"
            weatherTextView.text = weatherText
        }
    }
}

data class WeatherResponse(val main: MainData, val weather: List<WeatherData>)
data class MainData(val temp: Double)
data class WeatherData(val description: String)