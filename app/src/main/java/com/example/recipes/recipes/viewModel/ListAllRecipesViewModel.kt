package com.example.foods.features.recipes.viewModel

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foods.features.recipes.model.Recipe
import com.example.foods.features.recipes.model.ResultListener

typealias RecipeListResult = ResultListener<List<Recipe>>

interface ListAllRecipes {
    fun fetchAllRecipes(result: RecipeListResult)
}

typealias Bind<T> = (T) -> Unit

class ListAllRecipesViewModel(private val repository: ListAllRecipes): ViewModel() {

    private val error = MutableLiveData<String>()
    private val isLoading = MutableLiveData<Boolean>()
    private val recipes = MutableLiveData<List<Recipe>>()

    fun observeError(owner: LifecycleOwner, onChange: Bind<String>) {
        error.observe(owner) { onChange(it) }
    }

    fun observeIsLoading(owner: LifecycleOwner, onChange: Bind<Boolean>) {
        isLoading.observe(owner) { onChange(it) }
    }

    fun observeRecipes(owner: LifecycleOwner, onChange: Bind<List<RecipeViewData>>) {
        recipes.observe(owner) { recipes ->
            val viewDatas = recipes.map { it.toViewData() }
            onChange(viewDatas)
        }
    }

    fun listRecipes() {
        isLoading.postValue(true)

        repository.fetchAllRecipes(object: RecipeListResult {
            override fun onSuccess(data: List<Recipe>) = onSuccessHandler(data)
            override fun onFailure(error: Error) = onFailureHandler(error)
        })
    }

    fun getRecipe(position: Int) = recipes.value?.get(position)

    private fun onSuccessHandler(data: List<Recipe>) {
        recipes.postValue(data)
        isLoading.postValue(false)
    }

    private fun onFailureHandler(error: Error) {
        this.error.postValue(error.message!!)
        isLoading.postValue(false)
    }
}

fun Recipe.toViewData(): RecipeViewData {
    val createdDate = createdAt.toString()
    return RecipeViewData(title, description, author, createdDate, thumbnailUrl)
}