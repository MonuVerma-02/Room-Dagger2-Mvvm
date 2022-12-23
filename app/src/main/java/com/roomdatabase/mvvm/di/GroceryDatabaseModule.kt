package com.roomdatabase.mvvm.di

import android.app.Application
import com.roomdatabase.mvvm.database.GroceryDao
import com.roomdatabase.mvvm.database.GroceryDatabase
import dagger.Module
import dagger.Provides

@Module
class GroceryDatabaseModule(private val app: Application) {

    @Provides
    fun provideGroceryDatabase(): GroceryDatabase {
        return GroceryDatabase(app)
    }

    @Provides
    fun provideGroceryDao(db: GroceryDatabase): GroceryDao {
        return db.getGroceryDao()
    }

}