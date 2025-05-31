package com.example.confessionsapp.ui.screens

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import com.example.confessionsapp.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RegistrationScreen(){
    var context = LocalContext.current;

    var name by remember{
        mutableStateOf("");
    }

    var surname by remember {
        mutableStateOf("");
    }

    var email by remember {
        mutableStateOf("");
    }

    var password by remember {
        mutableStateOf("");
    }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Image(
            painter = painterResource(R.drawable.app_logo),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp) // Set the desired size (adjust as needed)
                .padding(8.dp), // Optional padding
            contentScale = ContentScale.Fit // Ensures the image fits inside the bounds
        )

        Spacer(modifier = Modifier.height(20.dp));

        OutlinedTextField(
            value = name,
            onValueChange = {name=it},
            label = {Text("Name")},
            placeholder = {Text("John - example")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(15.dp));

        OutlinedTextField(
            value = surname,
            onValueChange = {surname=it},
            label = {Text("Surname")},
            placeholder = {Text("Doe - example")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(15.dp));

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = {Text("Email")},
            placeholder = {Text("adi.cizmic@stu.ibu.edu.ba")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            )
        )

        Spacer(modifier = Modifier.height(15.dp));

        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = {Text("Password")},
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Next
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(15.dp));

        Button(onClick = {
            if(checkPassword(password)){
                Toast.makeText(context, "Registration is successful", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "Password is invalid", Toast.LENGTH_SHORT).show();
            }
        }) {Text("REGISTER YOUR ACCOUNT")}
    }
}

fun checkPassword(password: String): Boolean{
    if(password.length<4){
        return false;
    }
    return true;
}
