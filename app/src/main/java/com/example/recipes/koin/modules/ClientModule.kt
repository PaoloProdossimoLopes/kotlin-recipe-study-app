package com.example.recipes.koin.modules

import com.example.foods.features.recipes.client.RecipeClient
import com.example.recipes.InmemmoryRecipeClient
import org.koin.dsl.module

val clientModule = module {
    single<RecipeClient> { InmemmoryRecipeClient() }
}