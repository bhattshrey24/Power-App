package com.example.powerapp.domain.models


data class Template(
    val templateId: Int,
    var name: String,
    var numOfDays: Int,
    var days: List<TemplateDay>
)