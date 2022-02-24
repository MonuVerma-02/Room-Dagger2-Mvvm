package com.roomdatabase.mvvm.di

import android.app.Application

class GroceryApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        appComponent = initDagger(this)

    }

    private fun initDagger(app: GroceryApplication): AppComponent =
        DaggerAppComponent.builder()
            .groceryDatabaseModule(GroceryDatabaseModule(app))
            .build()
}