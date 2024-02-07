package com.example.powerapp.domain.models

import com.example.powerapp.domain.models.enums.ExerciseTypes
import com.example.powerapp.domain.models.enums.MuscleGroups


data class Exercise (
    val exerciseId:Int,
    val history: List<SetHistory>,
    val exerciseName:String,
    val primaryMuscleGroup: MuscleGroups,
    val secondaryMuscleGroup: MuscleGroups,
    val exerciseType: ExerciseTypes,
    val isTimerRequired:Boolean
)