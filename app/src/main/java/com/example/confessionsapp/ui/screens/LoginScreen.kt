package com.example.confessionsapp.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.confessionsapp.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable

fun LoginScreen(){
    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "SPILLIT")
        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp) // Set the desired size (adjust as needed)
                .padding(8.dp), // Optional padding
            contentScale = ContentScale.Fit // Ensures the image fits inside the bounds
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = email, onValueChange = {email=it}, label = {
            Text(text = "Unesite e-mail adresu")
        })

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value = password, onValueChange = {password=it}, label = {
            Text(text = "Unesite šifru")
        })

        Spacer(modifier = Modifier.height(15.dp))

        Button( onClick = {
            Log.i("Email adresu", email)
        }) { Text(text = "Prijavi se")}

        Spacer(modifier = Modifier.height(20.dp))

        TextButton(onClick = {}) {Text(text = "Zaboravio si šifru?")}
    }
}
