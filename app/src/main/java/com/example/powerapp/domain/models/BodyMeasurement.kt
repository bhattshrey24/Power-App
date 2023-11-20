package com.example.powerapp.domain.models

import com.example.powerapp.domain.models.enums.BodyParts
import java.time.LocalDateTime

data class BodyMeasurement (
    val measurementId : Int,
    val date: LocalDateTime,
    val bodyParts: BodyParts,
    val measurement:Float
)