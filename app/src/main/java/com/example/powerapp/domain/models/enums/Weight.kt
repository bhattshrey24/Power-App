package com.example.powerapp.domain.models.enums

sealed class Weight() {
    data class KG(var value:Int, var unit:String="KG"):Weight()
    data class P(var value:Int, var unit:String="P"):Weight()
}