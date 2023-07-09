package com.example.foods.features.recipes.repository

import com.example.foods.features.recipes.client.RecipeClient
import com.example.foods.features.recipes.client.RecipeResponse
import com.example.foods.features.recipes.model.Recipe
import com.example.foods.features.recipes.model.ResultListener
import com.example.foods.features.recipes.viewModel.ListAllRecipes
import com.example.foods.features.recipes.viewModel.RecipeListResult

class RemoteRecipeRepository(private val client: RecipeClient): ListAllRecipes {
    override fun fetchAllRecipes(result: RecipeListResult) {
        client.fetch(allRecipesResultHandler(result))
    }

    private fun allRecipesResultHandler(result: RecipeListResult): ResultListener<List<RecipeResponse>> {
        return object: ResultListener<List<RecipeResponse>> {
            override fun onSuccess(data: List<RecipeResponse>) = result.onSuccess(
                data.map { it.toRecipe() }
            )

            override fun onFailure(error: Error) = result.onFailure(error)
        }
    }
}

fun RecipeResponse.toRecipe(): Recipe = Recipe(id, title, description, ingredients, createdAt, author, thumbnailUrl)
