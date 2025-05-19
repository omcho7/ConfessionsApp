package com.example.confessionsapp.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.confessionsapp.R
import com.example.confessionsapp.data.ConfessionRepository
import com.example.confessionsapp.model.Confession
import androidx.compose.animation.core.*

@Composable
fun RouletteScreen() {
    var hasRolled by remember { mutableStateOf(false) }
    var targetAngle by remember { mutableStateOf(0f) }
    var currentPost by remember { mutableStateOf<Confession?>(null) }

    val animatedAngle by animateFloatAsState(
        targetValue = targetAngle,
        animationSpec = tween(durationMillis = 400, easing = EaseOut),
        label = "DiceSpin"
    )

    val confessions = ConfessionRepository.confessions

    val rollDice = {
        targetAngle += 360f
        hasRolled = true
        currentPost = confessions.random()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(visible = hasRolled && currentPost != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        text = currentPost?.category ?: "",
                        style = MaterialTheme.typography.titleSmall
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = currentPost?.content ?: "",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            if (!hasRolled) {
                Spacer(modifier = Modifier.height(24.dp))
                DiceButton(animatedAngle) { rollDice() }
            }
        }

        AnimatedVisibility(
            visible = hasRolled,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            DiceButton(animatedAngle) { rollDice() }
        }
    }
}

@Composable
fun DiceButton(angle: Float, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .graphicsLayer {
                rotationZ = angle
            }
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.dice),
            contentDescription = "Roll Dice"
        )
    }
}
