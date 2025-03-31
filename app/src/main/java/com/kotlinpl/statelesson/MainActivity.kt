package com.kotlinpl.statelesson

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.util.LogWriter
import com.kotlinpl.statelesson.ui.theme.StateLessonTheme
import kotlin.dec
import kotlin.inc
import kotlin.toString

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            var count = rememberSaveable { mutableStateOf(0) }
            StateLessonTheme {
                Scaffold { innerPadding ->
                    Counter(
                        modifier = Modifier.padding(innerPadding),
                        increment = { count.value++ },
                        decrement = { count.value-- },
                        count = count.value.toString()
                    )

                }
            }
        }
    }
}

@Composable
fun Counter(
    modifier: Modifier = Modifier,
    count: String,
    increment: () -> Unit,
    decrement: () -> Unit
) {

    Column(modifier = modifier) {
        Text(count)

        Row {
            Button(
                onClick = increment
            ) {
                Text("Incrementar")
            }

            Button(onClick = decrement) {
                Text("Decrementar")
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StateLessonTheme {
        Greeting("Android")
    }
}