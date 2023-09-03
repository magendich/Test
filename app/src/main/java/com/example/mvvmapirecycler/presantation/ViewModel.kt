package com.example.mvvmapirecycler.presantation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmapirecycler.data.PizzaRepository
import com.example.mvvmapirecycler.domain.PizzaModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PizzaViewModel @Inject constructor(
    private val repository: PizzaRepository
) : ViewModel() {

    private val mutablePizzas = MutableLiveData<List<PizzaModel>>()
    val observablePizzas: LiveData<List<PizzaModel>> = mutablePizzas

    fun fetchPizzas() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {

                val items = repository.getPizzas()

                mutablePizzas.postValue(items)

            }
        }
    }

    companion object {
        const val TAG = "PizzaViewModel"
    }
}

