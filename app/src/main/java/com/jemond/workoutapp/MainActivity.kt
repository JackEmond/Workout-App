    package com.jemond.workoutapp

    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.padding
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.AccountBox
    import androidx.compose.material.icons.filled.Favorite
    import androidx.compose.material.icons.filled.Home
    import androidx.compose.material3.Icon
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.adaptive.navigationsuite.NavigationSuiteScaffold
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.saveable.rememberSaveable
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.vector.ImageVector
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.tooling.preview.PreviewScreenSizes
    import com.jemond.workoutapp.ui.theme.WorkoutAppTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                WorkoutAppTheme {
                    WorkoutAppApp()
                }
            }
        }
    }

    @Preview
    @Composable
    fun WorkoutAppApp() {
        var currentDestination by rememberSaveable { mutableStateOf(AppDestinations.HOME) }
        var selectedExerciseName by rememberSaveable {
            mutableStateOf<String?>(null) }

        NavigationSuiteScaffold(
            navigationSuiteItems = {
                AppDestinations.entries.forEach {
                    item(
                        icon = {
                            Icon(
                                it.icon,
                                contentDescription = it.label
                            )
                        },
                        label = { Text(it.label) },
                        selected = it == currentDestination,
                        onClick = { currentDestination = it }
                    )
                }
            }
        ) {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val modifier = Modifier.padding(innerPadding)

                when (currentDestination) {
                    AppDestinations.HOME -> {
                        if(selectedExerciseName == null){
                            HomeScreen(
                                modifier,
                                onExerciseClick = {exercise -> selectedExerciseName = exercise.name})
                        }
                        else{
                            ExerciseDetailScreen(modifier = modifier,
                                exerciseName = selectedExerciseName!!,
                                onBack = { selectedExerciseName = null }

                            )

                        }
                    }
                    AppDestinations.FAVORITES -> FavouritesScreen(modifier)
                    AppDestinations.PROFILE -> ProfileScreen(modifier)
                }
            }
        }
    }



    @Composable
    fun FavouritesScreen(modifier: Modifier = Modifier) {
        Text("Favourite Content", modifier = modifier)
    }

    @Composable
    fun ProfileScreen(modifier: Modifier = Modifier) {
        Text("Profile Content", modifier = modifier)
    }



    enum class AppDestinations(
        val label: String,
        val icon: ImageVector,
    ) {
        HOME("Home", Icons.Default.Home),
        FAVORITES("Favorites", Icons.Default.Favorite),
        PROFILE("Profile", Icons.Default.AccountBox),
    }


