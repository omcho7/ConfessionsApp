package com.example.confessionsapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.confessionsapp.R
import com.example.confessionsapp.data.ConfessionRepository
import com.example.confessionsapp.model.Confession
import com.example.confessionsapp.ui.theme.CategoryBackground

@Composable
fun HomeFeedScreen() {
    val categories = listOf("All", "Love", "Family", "School", "Work", "Humor", "Dark")
    val categoryDisplayNames = mapOf(
        "All" to "⭐ All",
        "Love" to "❤️ Love",
        "Family" to "👨‍👩‍👧‍👦 Family",
        "School" to "🎓 School",
        "Work" to "💼 Work",
        "Humor" to "😂 Humor",
        "Dark" to "🖤 Dark"
    )

    var selectedCategory by remember { mutableStateOf("All") }

    val confessions = ConfessionRepository.confessions.filter {
        selectedCategory == "All" || it.category == selectedCategory
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        // App Logo + Title Row
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.app_logo),
                contentDescription = "App Logo",
                modifier = Modifier
                    .size(60.dp)
                    .padding(end = 8.dp)
            )
            Text(
                text = "Confessions",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }


        val scrollState = rememberScrollState()
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(bottom = 12.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            categories.forEach { category ->
                FilterChip(
                    selected = selectedCategory == category,
                    onClick = { selectedCategory = category },
                    label = { Text(categoryDisplayNames[category] ?: category) },
                    colors = FilterChipDefaults.filterChipColors(
                        selectedContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        containerColor = CategoryBackground
                    ),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(confessions) { confession ->
                ConfessionCard(confession)
            }
        }
    }
}

@Composable
fun ConfessionCard(confession: Confession) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Category and timestamp row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = confession.category,
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    text = confession.timestamp, // Directly use the string
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Rest of the card remains the same...
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = confession.title,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = confession.content,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Voting buttons
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Upvote button
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /* Handle upvote */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_upvote),
                            contentDescription = "Upvote"
                        )
                    }
                    Text(text = confession.upvotes.toString())
                }

                // Downvote button
                Row(verticalAlignment = Alignment.CenterVertically) {
                    IconButton(onClick = { /* Handle downvote */ }) {
                        Icon(
                            painter = painterResource(R.drawable.ic_downvote),
                            contentDescription = "Downvote"
                        )
                    }
                    Text(text = confession.downvotes.toString())
                }
            }
        }
    }
}