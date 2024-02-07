package com.example.powerapp.domain.models

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime

data class Workout (
    val workoutId:Int,
    val exercise:List<Exercise>,
    val calories:Float,
    val duration: Duration,
    val day: DayOfWeek,
    val date: LocalDateTime
)