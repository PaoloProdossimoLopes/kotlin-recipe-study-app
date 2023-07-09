package com.example.recipes.koin.modules

import com.example.foods.features.recipes.repository.RemoteRecipeRepository
import com.example.foods.features.recipes.viewModel.ListAllRecipes
import org.koin.dsl.module

val repositoryModule = module {
    factory<ListAllRecipes> {
        RemoteRecipeRepository(get())
    }
}