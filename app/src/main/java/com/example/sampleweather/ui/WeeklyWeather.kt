package com.example.sampleweather.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleweather.data.WEEKLY_FORECAST
import com.example.sampleweather.model.WeeklyForecast
import com.example.sampleweather.ui.theme.SampleWeatherTheme

@Composable
fun WeeklyItem(modifier: Modifier = Modifier, weeklyForecast: WeeklyForecast) {
    Card(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        elevation = 0.dp
    ) {
        Row {
            Text(
                text = weeklyForecast.date,
                color = Color.White,
                fontSize = 16.sp
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = weeklyForecast.weather.icon),
                    contentDescription = "Weather icon",
                    modifier = Modifier.size(80.dp)
                )
                Text(
                    text = stringResource(id = weeklyForecast.weather.weather),
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(8.dp)
                )
            }
            Row(modifier = Modifier.padding(start = 4.dp, top = 8.dp)) {
                repeat(3) {
                    PokemonItem(modifier = Modifier.size(64.dp))
                }
            }
        }
    }
}

@Composable
fun WeeklyWeather() {
    LazyColumn(
        modifier = Modifier.padding(16.dp)
    ) {
        items(WEEKLY_FORECAST.size) { index ->
            WeeklyItem(
                modifier = Modifier.padding(8.dp),
                weeklyForecast = WEEKLY_FORECAST[index]
            )
        }
    }
}

@Preview
@Composable
fun WeeklyWeatherPreview() {
    SampleWeatherTheme {
        WeeklyWeather()
    }
}

