package com.example.powerapp.domain.models

import com.example.powerapp.domain.models.enums.Weight

data class Exercise (
    val exerciseId:Int,
    val exerciseDetails: ExerciseDetails,
    val reps:Int,
    val sets:Int,
    val weight: Weight
)