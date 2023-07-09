package com.example.recipes.koin.modules

import com.example.recipes.glide.GlideImageProvider
import com.example.recipes.recipes.ui.ImageProvider
import org.koin.dsl.module

val glideModule = module {
    single<ImageProvider> { GlideImageProvider() }
}