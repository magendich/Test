package com.example.mvvmapirecycler.data

import android.util.Log
import com.example.mvvmapirecycler.domain.PizzaModel
import javax.inject.Inject

class PizzaRepository @Inject constructor(
    private val api: ApiRequestService
) {
    suspend fun getPizzas(): List<PizzaModel> {
        Log.d("MyLog", "RepositoryGetPizzas - ${api.getPizzas()}")
        return api.getPizzas().map {
            it.toDomain()
        }
    }
}