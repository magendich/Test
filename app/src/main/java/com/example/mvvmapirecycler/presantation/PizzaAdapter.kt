package com.example.mvvmapirecycler.presantation

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapirecycler.databinding.PizzaLayoutBinding
import com.example.mvvmapirecycler.domain.PizzaModel
import com.squareup.picasso.Picasso

class PizzaAdapter: androidx.recyclerview.widget.ListAdapter <PizzaModel, PizzaAdapter.PizzaViewHolder>(PizzaDiffUtil()) {

    class PizzaViewHolder(private val pizzaUi: PizzaLayoutBinding): RecyclerView.ViewHolder(pizzaUi.root) {

        fun bind(pizzaModel: PizzaModel) {
            pizzaUi.apply {
                Picasso.get().load(pizzaModel.img).into(pizzaUi.pizzaImage)
                pizzaTitle.text = pizzaModel.title
                pizzaDesc.text = pizzaModel.description
                btnBuy.text = pizzaModel.price + "р."
                pizzaIngredients.text = pizzaModel.ingredients.joinToString(", ")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        return PizzaViewHolder(PizzaLayoutBinding.inflate(LayoutInflater
            .from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class PizzaDiffUtil: DiffUtil.ItemCallback<PizzaModel>() {

        override fun areItemsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
             return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: PizzaModel, newItem: PizzaModel): Boolean {
            return oldItem == newItem
        }

    }
}