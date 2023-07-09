package com.example.recipes.recipes.ui

import android.content.Context
import android.net.Uri
import android.widget.ImageView

interface ImageProvider {
    fun loadFrom(uri: Uri, component: ImageView, context: Context)
}