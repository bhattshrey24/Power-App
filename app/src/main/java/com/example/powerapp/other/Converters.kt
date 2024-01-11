package com.example.powerapp.other

import com.example.powerapp.domain.models.Exercise
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    companion object {
        fun convertListOfExerciseToJson(listOfExercise: List<Exercise>): String {
            val gson = Gson()
            return gson.toJson(listOfExercise)
        }
        fun convertJsonToListOfExercise(json: String): List<Exercise> {
            val gson = Gson()
            val type = object : TypeToken<List<Exercise>>() {}.type
            return gson.fromJson(json, type)
        }
    }
}