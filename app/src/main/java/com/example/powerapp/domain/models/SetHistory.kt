package com.example.powerapp.domain.models

import java.time.LocalDate


data class SetHistory (
    val sets:List<Set>,
    val date: LocalDate
)