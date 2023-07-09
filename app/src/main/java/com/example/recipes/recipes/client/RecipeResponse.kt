package com.example.foods.features.recipes.client

import android.net.Uri
import java.io.Serializable
import java.util.Date
import java.util.UUID

data class RecipeResponse(
    val id: UUID,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val createdAt: Date,
    val author: String,
    val thumbnailUrl: Uri
): Serializable