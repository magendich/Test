package com.example.mvvmapirecycler.domain

data class PizzaModel(
    val title: String,
    val price: String,
    val img: String,
    val description: String,
    val ingredients: List<String>
)
