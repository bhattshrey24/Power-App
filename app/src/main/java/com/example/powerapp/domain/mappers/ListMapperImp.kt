package com.example.powerapp.domain.mappers

class ListMapperImp<I,O>(
    private val mapper:Mapper<I,O>
):ListMapper<I,O>{
    override fun map(input: List<I>): List<O> {
        return input.map {
            mapper.map(it)
        }
    }
}