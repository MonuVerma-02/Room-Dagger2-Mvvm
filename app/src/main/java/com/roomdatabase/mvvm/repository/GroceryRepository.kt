package com.roomdatabase.mvvm.repository

import com.roomdatabase.mvvm.database.GroceryDatabase
import com.roomdatabase.mvvm.database.entity.GroceryItems
import javax.inject.Inject

class GroceryRepository @Inject constructor(private val db: GroceryDatabase) {

    suspend fun insert(item: GroceryItems) = db.getGroceryDao().insert(item)

    suspend fun delete(item: GroceryItems) = db.getGroceryDao().delete(item)

    fun getAllGroceryItems() = db.getGroceryDao().getAllGroceryItems()

}