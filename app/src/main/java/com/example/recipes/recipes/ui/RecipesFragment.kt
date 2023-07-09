package com.example.recipes.recipes.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foods.features.recipes.viewModel.ListAllRecipesViewModel
import com.example.foods.features.recipes.viewModel.RecipeViewData
import com.example.recipes.R
import com.example.recipes.databinding.FragmentRecipesBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecipesFragment : Fragment(R.layout.fragment_recipes) {

    private lateinit var binding: FragmentRecipesBinding
    private val adapter = RecipeListAdapter<RecipeViewData>()
    private val imageProvider: ImageProvider by inject()
    private val viewModel: ListAllRecipesViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentRecipesBinding.bind(view)

        registerViewHolders()
        configureRecycler()
        configureViewModelOnChange(view)
    }

    override fun onResume() {
        super.onResume()
        viewModel.listRecipes()
    }

    private fun registerViewHolders() {
        adapter.register(RecipeItemViewHolder.IDENTIFIER) { parent ->
            RecipeItemViewHolder.instantiate(parent, imageProvider, onClick = { position ->
                viewModel.getRecipe(position)?.let { recipe ->
                    val action = RecipesFragmentDirections.actionFromRecipeListToRecipeDetail(recipe)
                    findNavController().navigate(action)
                }
            })
        }
    }

    private fun configureRecycler() {
        with(binding) {
            recyclerRecipes.adapter = adapter
            recyclerRecipes.layoutManager = LinearLayoutManager(context)
        }
    }

    private fun configureViewModelOnChange(view: View) {
        viewModel.observeRecipes(viewLifecycleOwner) { recipes ->
            val items = recipes.map { recipe -> ItemViewData(RecipeItemViewHolder.IDENTIFIER, recipe) }
            adapter.update(items)
        }

        viewModel.observeError(viewLifecycleOwner) { errorMessage ->
            Snackbar.make(view, errorMessage, Snackbar.LENGTH_LONG).show()
        }

        viewModel.observeIsLoading(viewLifecycleOwner) { isLoading ->
            binding.progressLoader.isVisible = isLoading
            binding.recyclerRecipes.isVisible = !isLoading
        }
    }
}