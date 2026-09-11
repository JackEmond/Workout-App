package com.jemond.workoutapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ExerciseDetailScreen(
    exerciseName: String,
    onBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Button(onClick = onBack) {
            Text("Back")
        }
        Text(
            text = exerciseName,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )
        Text("Detailed instructions for $exerciseName would go here.")
    }
}

@Preview(showBackground = true, showSystemUi = true) // Adds the phone frame
@Composable
fun ExerciseDetailScreenPreview() {
    ExerciseDetailScreen(
        exerciseName = "Bench Press",
        onBack = {}
    )
}