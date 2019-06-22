package com.example.myapplication

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("/organizacion")
    fun allOrganizaciones(): Call<List<organizacion>>

    @GET("/veterinaria")
    fun allVeterinarias(): Call<List<veterinaria>>



}