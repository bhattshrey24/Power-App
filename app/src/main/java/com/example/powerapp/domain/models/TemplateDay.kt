package com.example.powerapp.domain.models

import java.time.DayOfWeek

data class TemplateDay(
    var name:String,
    var calories: Float,
    var volume: Int,
    var day: DayOfWeek,
    var listOfExercises: List<Pair<Exercise, List<Set>>>
)