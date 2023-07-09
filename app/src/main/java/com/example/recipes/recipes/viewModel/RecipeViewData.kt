package com.example.foods.features.recipes.viewModel

import android.net.Uri

data class RecipeViewData(
    val title: String,
    val description: String,
    val author: String,
    val acreatedAt: String,
    val thumbnailUrl: Uri
)