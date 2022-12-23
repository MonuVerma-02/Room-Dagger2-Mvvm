package com.roomdatabase.mvvm.repository

import com.roomdatabase.mvvm.database.GroceryDao
import com.roomdatabase.mvvm.database.GroceryDatabase
import com.roomdatabase.mvvm.database.entity.GroceryItems
import javax.inject.Inject

class GroceryRepository @Inject constructor(private val dao: GroceryDao) {

    suspend fun insert(item: GroceryItems) = dao.insert(item)

    suspend fun delete(item: GroceryItems) = dao.delete(item)

    fun getAllGroceryItems() = dao.getAllGroceryItems()

}