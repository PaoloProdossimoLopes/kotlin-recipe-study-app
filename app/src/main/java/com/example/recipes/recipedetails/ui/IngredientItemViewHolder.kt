package com.example.recipes.recipedetails.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recipes.databinding.IngredientItemBinding
import com.example.recipes.recipes.ui.ItemViewHolder
import java.util.UUID

class IngredientItemViewHolder private constructor(private val binding: IngredientItemBinding): ItemViewHolder<String>(binding.root) {

    companion object {
        val IDENTIFIER: Int by lazy { IngredientItemViewHolder.hashCode() }
        fun instance(parent: ViewGroup): IngredientItemViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = IngredientItemBinding.inflate(inflater, parent, false)
            return IngredientItemViewHolder(binding)
        }
    }

    override fun bind(viewData: String) {
        with (binding) {
            textIngredientItemTitle.text = viewData
        }
    }
}