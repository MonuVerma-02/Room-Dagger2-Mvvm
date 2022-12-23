package com.roomdatabase.mvvm.di

import com.roomdatabase.mvvm.database.GroceryDao
import com.roomdatabase.mvvm.repository.GroceryRepository
import dagger.Module
import dagger.Provides

@Module
class GroceryRepositoryModule {

    @Provides
    fun provideGroceryRepository(doa: GroceryDao):GroceryRepository{
        return GroceryRepository(doa)
    }
}