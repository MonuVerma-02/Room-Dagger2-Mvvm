package com.roomdatabase.mvvm.di

import com.roomdatabase.mvvm.database.GroceryDatabase
import com.roomdatabase.mvvm.repository.GroceryRepository
import dagger.Module
import dagger.Provides

@Module
class GroceryRepositoryModule {

    @Provides
    fun provideGroceryRepository(database: GroceryDatabase):GroceryRepository{
        return GroceryRepository(database)
    }
}