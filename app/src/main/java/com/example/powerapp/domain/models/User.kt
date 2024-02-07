package com.example.powerapp.domain.models

import java.time.LocalDate

data class User (
    val userId:Int,
    val name:Int,
    val age:Int,
    val dob: LocalDate,
    val weight: Float
)