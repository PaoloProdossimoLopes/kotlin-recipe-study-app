package com.example.foods.features.recipes.model

interface ResultListener<T> {
    fun onSuccess(data: T)
    fun onFailure(error: Error)
}