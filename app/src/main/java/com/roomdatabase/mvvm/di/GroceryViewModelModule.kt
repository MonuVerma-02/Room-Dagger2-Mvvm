package com.roomdatabase.mvvm.di

import com.roomdatabase.mvvm.repository.GroceryRepository
import com.roomdatabase.mvvm.viewmodel.GroceryViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class GroceryViewModelModule {

    @Provides
    fun provideGroceryViewModel(repository: GroceryRepository): GroceryViewModelFactory {
        return GroceryViewModelFactory(repository)
    }
}