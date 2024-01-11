package com.example.powerapp.presentation.screens.dummy

import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.domain.models.ExerciseDetails
import com.example.powerapp.domain.models.SetHistory
import com.example.powerapp.domain.models.Sets
import com.example.powerapp.domain.models.enums.ExerciseTypes
import com.example.powerapp.domain.models.enums.MuscleGroups
import java.time.LocalDate


val dummyListOfExercises = listOf<Exercise>(
    Exercise(
        exerciseId = 1,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(10, 12),
                    Sets(15, 10)
                ), date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Bench Press",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Chest,
            secondaryMuscleGroup = MuscleGroups.Chest,
            exerciseType = ExerciseTypes.Barbell,
        )
    ),
    Exercise(
        exerciseId = 2,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(20, 10),
                    Sets(35, 12),
                    Sets(40, 14),
                    Sets(45, 16)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Chest Fly",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Chest,
            secondaryMuscleGroup = MuscleGroups.Chest,
            exerciseType = ExerciseTypes.Machine,
        )
    ),
    Exercise(
        exerciseId = 3,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(20, 12),
                    Sets(35, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Inclined Bench",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Chest,
            secondaryMuscleGroup = MuscleGroups.Chest,
            exerciseType = ExerciseTypes.Machine,
        )
    ),
    Exercise(
        exerciseId = 4,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(40, 12),
                    Sets(55, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Pull Ups",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Back,
            secondaryMuscleGroup = MuscleGroups.Shoulder,
            exerciseType = ExerciseTypes.Machine,
        )
    ),

    Exercise(
        exerciseId = 5,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(60, 12),
                    Sets(65, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Deadlift",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Back,
            secondaryMuscleGroup = MuscleGroups.Legs,
            exerciseType = ExerciseTypes.Machine,
        )
    ),
    Exercise(
        exerciseId = 6,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(70, 12),
                    Sets(75, 10),
                    Sets(85, 10)

                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Squats",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Legs,
            secondaryMuscleGroup = MuscleGroups.Core,
            exerciseType = ExerciseTypes.Machine,
        )
    ),
    Exercise(
        exerciseId = 7,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(80, 12),
                    Sets(85, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Lunges",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Legs,
            secondaryMuscleGroup = MuscleGroups.Core,
            exerciseType = ExerciseTypes.Machine,
        )
    ),
    Exercise(
        exerciseId = 8,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Sets(90, 12),
                    Sets(95, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseDetails = ExerciseDetails(
            exerciseName = "Calf raise",
            isTimerRequired = false,
            primaryMuscleGroup = MuscleGroups.Legs,
            secondaryMuscleGroup = MuscleGroups.Core,
            exerciseType = ExerciseTypes.Machine,
        )
    ),

)