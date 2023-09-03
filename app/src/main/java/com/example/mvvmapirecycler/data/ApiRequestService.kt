package com.example.mvvmapirecycler.data

import retrofit2.http.GET

interface ApiRequestService {
    @GET("pizzatest.php")
    suspend fun getPizzas(): List<PizzaDto>
}