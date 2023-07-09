package com.example.foods.features.recipes.model

import android.net.Uri
import java.io.Serializable
import java.util.Date
import java.util.UUID

data class Recipe(
    val id: UUID,
    val title: String,
    val description: String,
    val ingredients: List<String>,
    val createdAt: Date,
    val author: String,
    val thumbnailUrl: Uri
): Serializable