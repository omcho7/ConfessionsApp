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
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.unit.Dp

@Composable
fun RouletteScreen() {
    var hasRolled by remember { mutableStateOf(false) }
    var targetAngle by remember { mutableStateOf(0f) }
    var currentPost by remember { mutableStateOf<Confession?>(null) }

    // Gravity-based hop animation
    val infiniteHop = rememberInfiniteTransition()
    val hopProgress by infiniteHop.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = keyframes {
                durationMillis = 1300 // Increased total duration for pause
                // Jump up (fast)
                0.0f at 0 with LinearOutSlowInEasing
                0.7f at 400 with FastOutSlowInEasing
                // Fall down (slower)
                0.0f at 900 with LinearOutSlowInEasing
                // Pause at bottom (stay at 0)
                0.0f at 1300
            },
            repeatMode = RepeatMode.Restart
        )
    )

    // Convert progress to physical motion
    val hopHeight = 20.dp // Max hop height
    val verticalOffset = when {
        hopProgress < 0.5f -> hopProgress * 2 // Going up
        else -> (1 - hopProgress) * 2 // Coming down
    }

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

    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(visible = hasRolled && currentPost != null) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(text = /*Fix this part to load category*/ "", style = MaterialTheme.typography.titleSmall)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = currentPost?.body ?: "",
                        style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }

            if (!hasRolled) {
                Spacer(modifier = Modifier.height(24.dp))
                DiceButton(
                    angle = animatedAngle,
                    verticalOffset = verticalOffset,
                    hopHeight = hopHeight,
                    onClick = rollDice
                )
            }
        }

        AnimatedVisibility(
            visible = hasRolled,
            modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 40.dp)
        ) {
            DiceButton(
                angle = animatedAngle,
                verticalOffset = 0f, // No hop after first roll
                hopHeight = hopHeight,
                onClick = rollDice
            )
        }
    }
}

@Composable
fun DiceButton(
    angle: Float,
    verticalOffset: Float,
    hopHeight: Dp,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .size(80.dp)
            .graphicsLayer {
                rotationZ = angle
                translationY = -verticalOffset * hopHeight.toPx()
                // Slight rotation during hop for realism
                rotationX = verticalOffset * 15f
            }
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            ),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.dice),
            contentDescription = "Roll Dice",
            modifier = Modifier.fillMaxSize()
        )
    }
}