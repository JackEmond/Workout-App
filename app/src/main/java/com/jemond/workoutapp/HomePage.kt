package com.jemond.workoutapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jemond.workoutapp.ui.theme.WorkoutAppTheme

data class Exercise(
    val name: String,
    val category: String
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onExerciseClick: (Exercise) -> Unit) {
    Column(modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)){
        Text(
            "Find an Exercise",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold )
        /* To Do Add a search bar */
        /* To Do add a button to filter by upper or lower body */
        val exercises = listOf(
            Exercise(name = "Bench Press", category = "Upper Body"),
            Exercise(name = "Squat", category = "Lower Body"),
            Exercise(name = "Pull Up", category = "Upper Body")
        )

        ListOfExercises(exercises, onExerciseClick = onExerciseClick)
    }

}

@Composable
fun ListOfExercises(exercises: List<Exercise>,
                    onExerciseClick: (Exercise) -> Unit) {
    LazyColumn {
        items(exercises.size) { index ->
            val exercise = exercises[index]

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
            Text(
                text = exercise.name,
                fontSize = 18.sp,
                modifier = Modifier.weight(1f)
            )
                /* onclick open a new page */
            Button(onClick = { onExerciseClick(exercise) }) {
                Text(text = ">")
            }
            }

        }
    }
}


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
fun HomeScreenPreview() {
    WorkoutAppTheme {
        WorkoutAppApp()
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