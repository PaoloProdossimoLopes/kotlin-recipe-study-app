package com.example.recipes.recipedetails.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipes.R
import com.example.recipes.databinding.FragmentRecipeDetailBinding
import com.example.recipes.recipes.ui.ImageProvider
import com.example.recipes.recipes.ui.ItemViewData
import com.example.recipes.recipes.ui.ListItemType
import com.example.recipes.recipes.ui.RecipeListAdapter
import org.koin.android.ext.android.inject

class RecipeDetailFragment : Fragment(R.layout.fragment_recipe_detail) {
    private val recipeArg: RecipeDetailFragmentArgs by navArgs()
    private val imageProvider: ImageProvider by inject()
    private val ingredientsListAdapter = RecipeListAdapter<String>()
    private lateinit var binding: FragmentRecipeDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipeDetailBinding.bind(view)

        configureBackAction()
        registerItemViewHolders()

        inputRecipeDetails()
        cofigureIngredientsRecyclerView()
        loadImage()
        inputIngredients()
    }

    private fun configureBackAction() {
        binding.imageRecipeDetailBackImage.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun registerItemViewHolders() {
        ingredientsListAdapter.register(IngredientItemViewHolder.IDENTIFIER) { parent ->
            IngredientItemViewHolder.instance(parent)
        }
    }

    private fun inputRecipeDetails() {
        val recipes = recipeArg.recipe

        with (binding) {
            textRecipeDetailTitle.text = recipes.title
            textRecipeDetailDescription.text = recipes.description
            textRecipeDetailAuthor.text = recipes.author
        }
    }

    private fun cofigureIngredientsRecyclerView() {
        with(binding.recyclerRecipeDetailIngredients) {
            adapter = ingredientsListAdapter
            layoutManager = object: LinearLayoutManager(binding.root.context) {
                override fun canScrollHorizontally() = false
                override fun canScrollVertically() = false
            }
        }
    }

    private fun loadImage() {
        val url = recipeArg.recipe.thumbnailUrl
        val imageView = binding.iamgeRecipeDetailImage
        val context = binding.root.context
        imageProvider.loadFrom(url, imageView, context)
    }

    private fun inputIngredients() {
        val ingredients = recipeArg.recipe.ingredients
        val itemViewDatas = ingredients.map { map(it) }
        ingredientsListAdapter.update(itemViewDatas)
    }

    private fun map(ingredient: String): ItemViewData<String> {
        return ItemViewData(IngredientItemViewHolder.IDENTIFIER, ingredient)
    }
}