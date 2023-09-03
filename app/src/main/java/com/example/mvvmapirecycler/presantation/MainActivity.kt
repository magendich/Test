package com.example.mvvmapirecycler.presantation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapirecycler.R
import com.example.mvvmapirecycler.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Retrofit

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var _ui: ActivityMainBinding? = null
    private val ui: ActivityMainBinding
        get() = _ui!!

    private val viewModel: PizzaViewModel by viewModels()

    private val pizzaAdapter = PizzaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        initViews()
        observe()

        viewModel.fetchPizzas()

    }

    private fun initViews() {
        with (ui) {
            mainRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
            mainRecyclerView.adapter = pizzaAdapter

            swipe.setOnRefreshListener {
                viewModel.fetchPizzas()
            }
        }
    }

    private fun observe() {
        viewModel.observablePizzas.observe(this) { pizzas ->
            ui.swipe.isRefreshing = false
            pizzaAdapter.submitList(pizzas)
            Log.d("MyLog", "submitList(pizzas)")
        }
    }
}