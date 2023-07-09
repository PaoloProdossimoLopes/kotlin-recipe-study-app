package com.example.recipes.recipes.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.foods.features.recipes.viewModel.RecipeViewData
import com.example.recipes.databinding.RecipeItemBinding
import com.example.recipes.recipedetails.ui.IngredientItemViewHolder

class RecipeItemViewHolder private constructor(private val binding: RecipeItemBinding, private val imageProvider: ImageProvider, private val onClick: (position: Int) -> Unit) : ItemViewHolder<RecipeViewData>(binding.root) {
    companion object {
        val IDENTIFIER: Int by lazy { RecipeItemViewHolder.hashCode() }
        fun instantiate(parent: ViewGroup, imageProvider: ImageProvider, onClick: (position: Int) -> Unit): RecipeItemViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val binding = RecipeItemBinding.inflate(inflater, parent, false)

            return RecipeItemViewHolder(binding, imageProvider, onClick)
        }
    }

    override fun bind(viewData: RecipeViewData) {
        with(binding) {
            textRecipeTitle.text = viewData.title
            textRecipeDescription.text = viewData.description

            imageProvider.loadFrom(viewData.thumbnailUrl, imageRecipe, itemView.context)
        }

        val position = layoutPosition
        binding.imageRecipeDetailIndicator.setOnClickListener { onClick(position) }
    }
}
