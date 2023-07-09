package com.example.recipes.koin.modules

import com.example.foods.features.recipes.viewModel.ListAllRecipesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { ListAllRecipesViewModel(get()) }
}