package com.menesdurak.rickandmorty.common

interface Mapper<I,O>{
    fun map(input:I):O
}