package com.example.foods.koin

import com.example.foods.application.ApplicationConfigurator
import com.example.recipes.koin.modules.clientModule
import com.example.recipes.koin.modules.glideModule
import com.example.recipes.koin.modules.imageProviderModule
//import com.example.recipes.koin.modules.recyclerAdapterModule
import com.example.recipes.koin.modules.repositoryModule
import com.example.recipes.koin.modules.viewModelModule
import org.koin.core.context.startKoin


class KoinConfigurator: ApplicationConfigurator {
    override fun configureOnCreate() {
        startKoin { modules(
            clientModule,
            glideModule,
            repositoryModule,
            viewModelModule,
            imageProviderModule,
//            recyclerAdapterModule
        ) }
    }
}