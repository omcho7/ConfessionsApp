package com.example.confessionsapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.confessionsapp.data.ConfessionRepository
import com.example.confessionsapp.model.Confession
import com.example.confessionsapp.ui.theme.CategoryBackground

@Composable
fun HomeFeedScreen() {
    val categories = listOf("All", "Love", "Family", "School", "Work", "Humor")
    var selectedCategory by remember { mutableStateOf("All") }

    val confessions = ConfessionRepository.confessions.filter {
        selectedCategory == "All" || it.category == selectedCategory
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)
        .padding(16.dp)) {

        CategorySelector(categories, selectedCategory) {
            selectedCategory = it
        }

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn {
            items(confessions) { confession ->
                ConfessionCard(confession)
                Spacer(modifier = Modifier.height(12.dp))
            }
        }
    }
}

@Composable
fun CategorySelector(
    categories: List<String>,
    selected: String,
    onSelect: (String) -> Unit
) {
    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        categories.forEach { category ->
            FilterChip(
                selected = selected == category,
                onClick = { onSelect(category) },
                label = { Text(category) },
                colors = FilterChipDefaults.filterChipColors(
                    selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                    containerColor = CategoryBackground
                )
            )
        }
    }
}

@Composable
fun ConfessionCard(confession: Confession) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = confession.category, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.primary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = confession.content, style = MaterialTheme.typography.bodyMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                confession.reactions.forEach { (emoji, count) ->
                    Text("$emoji $count")
                }
            }
        }
    }
}