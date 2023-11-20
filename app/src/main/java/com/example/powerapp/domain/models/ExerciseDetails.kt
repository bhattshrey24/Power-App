package com.example.powerapp.domain.models

import com.example.powerapp.domain.models.enums.ExerciseTypes
import com.example.powerapp.domain.models.enums.MuscleGroups

data class ExerciseDetails (
    val exerciseDetailsId:Int,
    val exerciseName:String,
    val primaryMuscleGroup:MuscleGroups,
    val secondaryMuscleGroup:MuscleGroups,
    val exerciseType:ExerciseTypes,
    val isTimerRequired:Boolean
)