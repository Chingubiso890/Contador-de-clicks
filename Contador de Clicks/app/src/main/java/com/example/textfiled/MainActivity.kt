package com.example.clickcounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.clickcounter.ui.theme.ClickCounterTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val counterViewModel: CounterViewModel by viewModels()

        setContent {
            ClickCounterTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    CounterScreen(counterViewModel)
                }
            }
        }
    }
}

@Composable
fun CounterScreen(viewModel: CounterViewModel = viewModel()) {
    val counter = viewModel.counter.observeAsState(initial = 0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Contador: ${counter.value}",
            style = MaterialTheme.typography.h4
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewModel.incrementCounter() }) {
            Text(text = "Clique Aqui")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ClickCounterTheme {
        CounterScreen()
    }
}
