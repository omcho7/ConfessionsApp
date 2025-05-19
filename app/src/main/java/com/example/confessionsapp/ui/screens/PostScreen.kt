package com.example.confessionsapp.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun PostScreen() {
    var selectedCategory by remember { mutableStateOf("") }
    var title by remember { mutableStateOf(TextFieldValue("")) }
    var content by remember { mutableStateOf(TextFieldValue("")) }

    val categories = listOf("Love", "School", "Family", "Humor", "Work")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Create a Post",
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
        )

        // Category selection via dropdown replacement
        Text("Select a Category:")
        categories.forEach { category ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { selectedCategory = category }
                    .padding(vertical = 4.dp)
            ) {
                RadioButton(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category }
                )
                Text(text = category)
            }
        }

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = content,
            onValueChange = { content = it },
            label = { Text("Confession") },
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                // Handle submission
                println("Post Submitted: $selectedCategory, ${title.text}, ${content.text}")
            }) {
                Text("Submit")
            }

            OutlinedButton(onClick = {
                // Handle cancel/reset
                selectedCategory = ""
                title = TextFieldValue("")
                content = TextFieldValue("")
            }) {
                Text("Cancel")
            }
        }
    }
}
