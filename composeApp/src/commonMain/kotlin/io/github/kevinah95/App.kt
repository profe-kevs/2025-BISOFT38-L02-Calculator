package io.github.kevinah95

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import calculator.composeapp.generated.resources.Res
import calculator.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {

        val calculator = remember { Calculator() }
        var num1 by remember { mutableStateOf("") }
        var num2 by remember { mutableStateOf("") }
        var result by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            BasicTextField(
                value = num1,
                onValueChange = { num1 = it },
                modifier = Modifier.padding(8.dp)
                    .background(Color.Gray)

            )
            BasicTextField(
                value = num2,
                onValueChange = { num2 = it },
                modifier = Modifier.padding(8.dp)
                    .background(Color.Gray)
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)){
                Button(onClick = {
                    result = calculator.add(num1.toDouble(), num2.toDouble()).toString()
                }) { Text("+") }
            }

            Text(text = "Result: $result")
        }

    }
}