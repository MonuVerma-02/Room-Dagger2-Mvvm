package com.roomdatabase.mvvm.di

import com.roomdatabase.mvvm.ui.MainActivity
import com.roomdatabase.mvvm.viewmodel.GroceryViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [GroceryDatabaseModule::class, GroceryRepositoryModule::class, GroceryViewModelModule::class])
interface AppComponent {
    fun inject(mainActivity: MainActivity)
}