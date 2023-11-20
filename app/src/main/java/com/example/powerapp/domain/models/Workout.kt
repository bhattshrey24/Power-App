package com.example.powerapp.domain.models

import com.example.powerapp.domain.models.enums.Days
import java.time.Duration
import java.time.LocalDateTime

data class Workout (
    val workoutId:Int,
    val exercise:List<Exercise>,
    val calories:Float,
    val duration: Duration,
    val day: Days,
    val date: LocalDateTime
)