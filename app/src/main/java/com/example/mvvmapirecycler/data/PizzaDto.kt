package com.example.mvvmapirecycler.data

import com.example.mvvmapirecycler.domain.PizzaModel
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PizzaDto(
    val title: String,
    val price: String,
    val img: String,
    val description: String,

    @SerializedName("ingridients")
    val ingredients: List<String>
) : Serializable {

    fun toDomain(): PizzaModel {
        return PizzaModel(
            title = title,
            price = price,
            img = img,
            description = description,
            ingredients = ingredients
        )
    }
}
