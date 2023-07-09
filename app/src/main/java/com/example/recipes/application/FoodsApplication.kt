package com.example.foods.application

import android.app.Application
import com.example.foods.koin.KoinConfigurator

class FoodsApplication: Application() {
    private val configurators = listOf<ApplicationConfigurator>(
        KoinConfigurator()
    )

    override fun onCreate() {
        super.onCreate()
        configurators.forEach {
            it.configureOnCreate()
        }
    }
}
