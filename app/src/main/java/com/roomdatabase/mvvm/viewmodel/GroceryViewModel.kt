package com.roomdatabase.mvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.roomdatabase.mvvm.database.entity.GroceryItems
import com.roomdatabase.mvvm.repository.GroceryRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class GroceryViewModel @Inject constructor(private val repository: GroceryRepository) :
    ViewModel() {

    fun insert(item: GroceryItems) = GlobalScope.launch {
        repository.insert(item)
    }

    fun delete(item: GroceryItems) = GlobalScope.launch {
        repository.delete(item)
    }

    fun getAllGroceryItems() = repository.getAllGroceryItems()
}