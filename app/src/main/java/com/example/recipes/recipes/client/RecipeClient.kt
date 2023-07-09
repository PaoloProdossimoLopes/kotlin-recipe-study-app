package com.example.foods.features.recipes.client

import com.example.foods.features.recipes.model.ResultListener

interface RecipeClient {
    fun fetch(result: ResultListener<List<RecipeResponse>>)
}