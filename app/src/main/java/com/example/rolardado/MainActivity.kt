package com.example.rolardado

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.rolardado.ui.theme.RolarDadoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RolarDadoTheme {
                    AppRolarDado()
                }
            }
        }
    }

@Preview(showSystemUi = true)
@Composable
fun AppRolarDado(){
    var resultado by remember { mutableStateOf( 1) }
    var idImagem = when (resultado){
        1-> R.drawable.dice_1
        2-> R.drawable.dice_2
        3-> R.drawable.dice_3
        4-> R.drawable.dice_4
        5-> R.drawable.dice_5
       else -> R.drawable.dice_6
    }
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier= Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
        )
        Button(
            onClick = {
                resultado = (1 .. 6).random()
            }
        ) {
            Text(
                text = "Rolar",
                fontSize = 20.sp

            )
        }
    }
}
