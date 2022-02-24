package com.roomdatabase.mvvm.ui

import com.roomdatabase.mvvm.database.entity.GroceryItems

interface DialogListener {
    fun onAddButtonClicked(item: GroceryItems)
}