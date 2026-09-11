package com.jemond.workoutapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jemond.workoutapp.ui.theme.WorkoutAppTheme

data class Exercise(
    val name: String,
    val category: String
)

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier){
        Text("Find an Exercise")
        /* To Do Add a search bar */
        /* To Do add a button to filter by upper or lower body */
        val exercises = listOf(
            Exercise(name = "Bench Press", category = "Upper Body"),
            Exercise(name = "Squat", category = "Lower Body"),
            Exercise(name = "Pull Up", category = "Upper Body")
        )

        ListOfExercises(exercises)
    }

}

@Composable
fun ListOfExercises(exercises: List<Exercise>) {
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
                modifier = Modifier.weight(1f)
            )
            Button(onClick = { /*TODO*/ }) {
                Text(text = ">")
            }
            }

        }
    }
}


@Preview(showBackground = true, showSystemUi = true) // Adds the phone frame
@Composable
fun HomeScreenPreview() {
    WorkoutAppTheme {
        WorkoutAppApp()
    }
}