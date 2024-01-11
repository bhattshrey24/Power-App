package com.example.powerapp.domain.models


data class Exercise (
    val exerciseId:Int,
    val history: List<SetHistory>,
    val exerciseDetails: ExerciseDetails,
)