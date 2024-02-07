package com.example.powerapp.presentation.screens.dummy

import com.example.powerapp.domain.models.Exercise
import com.example.powerapp.domain.models.SetHistory
import com.example.powerapp.domain.models.Set
import com.example.powerapp.domain.models.Template
import com.example.powerapp.domain.models.TemplateDay
import com.example.powerapp.domain.models.enums.ExerciseTypes
import com.example.powerapp.domain.models.enums.MuscleGroups
import java.time.DayOfWeek
import java.time.LocalDate


val dummyListOfExercises = listOf<Exercise>(
    Exercise(
        exerciseId = 1,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(10, 12),
                    Set(15, 10)
                ), date = LocalDate.now()
            )
        ),
        exerciseName = "Bench Press",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Chest,
        secondaryMuscleGroup = MuscleGroups.Chest,
        exerciseType = ExerciseTypes.Barbell,

        ),
    Exercise(
        exerciseId = 2,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(20, 10),
                    Set(35, 12),
                    Set(40, 14),
                    Set(45, 16)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Chest Fly",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Chest,
        secondaryMuscleGroup = MuscleGroups.Chest,
        exerciseType = ExerciseTypes.Machine,

        ),
    Exercise(
        exerciseId = 3,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(20, 12),
                    Set(35, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Inclined Bench",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Chest,
        secondaryMuscleGroup = MuscleGroups.Chest,
        exerciseType = ExerciseTypes.Machine,

        ),
    Exercise(
        exerciseId = 4,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(40, 12),
                    Set(55, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Pull Ups",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Back,
        secondaryMuscleGroup = MuscleGroups.Shoulder,
        exerciseType = ExerciseTypes.Machine,

        ),

    Exercise(
        exerciseId = 5,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(60, 12),
                    Set(65, 10)
                ),

                date = LocalDate.now()
            )
        ),

        exerciseName = "Deadlift",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Back,
        secondaryMuscleGroup = MuscleGroups.Legs,
        exerciseType = ExerciseTypes.Machine,
    ),
    Exercise(
        exerciseId = 6,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(70, 12),
                    Set(75, 10),
                    Set(85, 10)

                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Squats",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Legs,
        secondaryMuscleGroup = MuscleGroups.Core,
        exerciseType = ExerciseTypes.Machine,
    ),
    Exercise(
        exerciseId = 7,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(80, 12),
                    Set(85, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Lunges",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Legs,
        secondaryMuscleGroup = MuscleGroups.Core,
        exerciseType = ExerciseTypes.Machine,
    ),
    Exercise(
        exerciseId = 8,
        history = listOf(
            SetHistory(
                sets = listOf(
                    Set(90, 12),
                    Set(95, 10)
                ),

                date = LocalDate.now()
            )
        ),
        exerciseName = "Calf raise",
        isTimerRequired = false,
        primaryMuscleGroup = MuscleGroups.Legs,
        secondaryMuscleGroup = MuscleGroups.Core,
        exerciseType = ExerciseTypes.Machine,
    ),
)

val dummyTemplateList = listOf<Template>(
    Template(
        templateId = 1,
        numOfDays = 3,
        name = "Full Body",
        days = listOf(
            TemplateDay(
                name = "Chest",
                listOfExercises = listOf(
                    dummyListOfExercises[0] to listOf<Set>(
                        Set(30, 12),
                        Set(40, 10),
                        Set(50, 8)
                    ),
                    dummyListOfExercises[1] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                    dummyListOfExercises[2] to listOf<Set>(
                        Set(70, 12),
                        Set(80, 10),
                        Set(90, 8)
                    )

                ),
                volume = 5000,
                calories = 240.0f,
                day = DayOfWeek.MONDAY
            ),
            TemplateDay(
                name = "Back",
                listOfExercises = listOf(
                    dummyListOfExercises[3] to listOf<Set>(
                        Set(10, 12),
                        Set(20, 10),
                        Set(30, 8)
                    ),
                    dummyListOfExercises[4] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                    dummyListOfExercises[5] to listOf<Set>(
                        Set(70, 12),
                        Set(80, 10),
                        Set(90, 8)
                    )

                ),
                volume = 8000,
                calories = 440.0f,
                day = DayOfWeek.WEDNESDAY
            ),
            TemplateDay(
                name = "Leg",
                listOfExercises = listOf(
                    dummyListOfExercises[6] to listOf<Set>(
                        Set(100, 12),
                        Set(120, 10),
                        Set(130, 8)
                    ),
                ),
                volume = 11000,
                calories = 840.0f,
                day = DayOfWeek.FRIDAY
            )
        )
    ),
    Template(
        templateId = 2,
        numOfDays = 6,
        name = "PPL",
        days = listOf(
            TemplateDay(
                name = "Push",
                listOfExercises = listOf(
                    dummyListOfExercises[0] to listOf<Set>(
                        Set(30, 12),
                        Set(40, 10),
                        Set(50, 8)
                    ),
                    dummyListOfExercises[1] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                    dummyListOfExercises[2] to listOf<Set>(
                        Set(70, 12),
                        Set(80, 10),
                        Set(90, 8)
                    )

                ),
                volume = 5000,
                calories = 240.0f,
                day = DayOfWeek.MONDAY
            ),
            TemplateDay(
                name = "Pull",
                listOfExercises = listOf(
                    dummyListOfExercises[3] to listOf<Set>(
                        Set(10, 12),
                        Set(20, 10),
                        Set(30, 8)
                    ),
                    dummyListOfExercises[4] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                    dummyListOfExercises[5] to listOf<Set>(
                        Set(70, 12),
                        Set(80, 10),
                        Set(90, 8)
                    )

                ),
                volume = 8000,
                calories = 440.0f,
                day = DayOfWeek.TUESDAY
            ),
            TemplateDay(
                name = "Leg",
                listOfExercises = listOf(
                    dummyListOfExercises[6] to listOf<Set>(
                        Set(100, 12),
                        Set(120, 10),
                        Set(130, 8)
                    ),
                ),
                volume = 11000,
                calories = 840.0f,
                day = DayOfWeek.WEDNESDAY
            ),
            TemplateDay(
                name = "Push",
                listOfExercises = listOf(
                    dummyListOfExercises[0] to listOf<Set>(
                        Set(10, 12),
                        Set(20, 10),
                        Set(30, 8)
                    ),
                    dummyListOfExercises[1] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                ),
                volume = 3000,
                calories = 140.0f,
                day = DayOfWeek.THURSDAY
            ),
            TemplateDay(
                name = "Pull",
                listOfExercises = listOf(
                    dummyListOfExercises[3] to listOf<Set>(
                        Set(10, 12),
                        Set(20, 10),
                        Set(30, 8)
                    ),
                    dummyListOfExercises[4] to listOf<Set>(
                        Set(40, 12),
                        Set(50, 10),
                        Set(60, 8)
                    ),
                ),
                volume = 6000,
                calories = 340.0f,
                day = DayOfWeek.FRIDAY
            ),
            TemplateDay(
                name = "Leg",
                listOfExercises = listOf(
                    dummyListOfExercises[6] to listOf<Set>(
                        Set(100, 12),
                        Set(120, 10),
                        Set(130, 8)
                    ),
                ),
                volume = 11000,
                calories = 840.0f,
                day = DayOfWeek.SATURDAY
            )
        )
    ),
)


//val dummyTemplateList = listOf<Template>(
//    Template(
//        name = "PPL",
//        numOfDays = 3,
//        days = List<TemplateDay>(
//            DayOfWeek.MONDAY to TemplateDay(
//                name = "Push",
//                day = DayOfWeek.MONDAY,
//                calories = 350.0f,
//                volume = 1000,
//                listOfExercises = listOf(
//                    dummyListOfExercises[0] to listOf<Set>(
//                        Set(weight = 10, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 30, reps = 15)
//                    ),
//                    dummyListOfExercises[1] to listOf<Set>(
//                        Set(weight = 12, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 32, reps = 25)
//                    )
//                )
//            ),
//            DayOfWeek.TUESDAY to TemplateDay(
//                name = "Pull",
//                day = DayOfWeek.TUESDAY,
//                calories = 450.0f,
//                volume = 1500,
//                listOfExercises = listOf(
//                    dummyListOfExercises[3] to listOf<Set>(
//                        Set(weight = 30, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 10, reps = 15)
//                    ),
//                    dummyListOfExercises[4] to listOf<Set>(
//                        Set(weight = 32, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 12, reps = 25)
//                    )
//                )
//            ),
//            DayOfWeek.WEDNESDAY to TemplateDay(
//                name = "Leg",
//                day = DayOfWeek.WEDNESDAY,
//                calories = 450.0f,
//                volume = 1500,
//                listOfExercises = listOf(
//                    dummyListOfExercises[6] to listOf<Set>(
//                        Set(weight = 30, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 10, reps = 15)
//                    ),
//                    dummyListOfExercises[7] to listOf<Set>(
//                        Set(weight = 32, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 12, reps = 25)
//                    )
//                )
//            )
//        )
//    ),
//    Template(
//        name = "Bro Split",
//        numOfDays = 4,
//        days = mapOf<DayOfWeek, TemplateDay>(
//            DayOfWeek.MONDAY to TemplateDay(
//                name = "Chest",
//                day = DayOfWeek.MONDAY,
//                calories = 350.0f,
//                volume = 1000,
//                listOfExercises = listOf(
//                    dummyListOfExercises[0] to listOf<Set>(
//                        Set(weight = 10, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 30, reps = 15)
//                    ),
//                    dummyListOfExercises[1] to listOf<Set>(
//                        Set(weight = 12, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 32, reps = 25)
//                    )
//                )
//            ),
//            DayOfWeek.WEDNESDAY to TemplateDay(
//                name = "Back",
//                day = DayOfWeek.WEDNESDAY,
//                calories = 450.0f,
//                volume = 1500,
//                listOfExercises = listOf(
//                    dummyListOfExercises[3] to listOf<Set>(
//                        Set(weight = 30, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 10, reps = 15)
//                    ),
//                    dummyListOfExercises[4] to listOf<Set>(
//                        Set(weight = 32, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 12, reps = 25)
//                    )
//                )
//            ),
//            DayOfWeek.FRIDAY to TemplateDay(
//                name = "Leg",
//                day = DayOfWeek.FRIDAY,
//                calories = 450.0f,
//                volume = 1500,
//                listOfExercises = listOf(
//                    dummyListOfExercises[6] to listOf<Set>(
//                        Set(weight = 30, reps = 10),
//                        Set(weight = 20, reps = 12),
//                        Set(weight = 10, reps = 15)
//                    ),
//                    dummyListOfExercises[7] to listOf<Set>(
//                        Set(weight = 32, reps = 20),
//                        Set(weight = 22, reps = 22),
//                        Set(weight = 12, reps = 25)
//                    )
//                )
//            )
//        )
//    )
//)
