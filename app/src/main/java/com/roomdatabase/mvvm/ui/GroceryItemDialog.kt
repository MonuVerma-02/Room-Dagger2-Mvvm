package com.roomdatabase.mvvm.ui

import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.roomdatabase.mvvm.database.entity.GroceryItems
import com.roomdatabase.mvvm.databinding.GroceryDialogBinding

class GroceryItemDialog(context: Context, var dialogListener: DialogListener) :
    AppCompatDialog(context) {

    private lateinit var binding: GroceryDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE)
        binding = GroceryDialogBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSave.setOnClickListener {
            val item = binding.etItemName.text.toString()
            val quantity = binding.etItemQuantity.text.toString()
            val price = binding.etItemPrice.text.toString()

            getGroceryItems(item, quantity, price)
        }

        binding.btnCancel.setOnClickListener {
            cancel()
        }
    }

    private fun getGroceryItems(item: String, quantity: String, price: String) {
        when {
            item.isEmpty() -> {
                Toast.makeText(context, "Please Enter Item", Toast.LENGTH_SHORT).show()
            }
            quantity.isEmpty() -> {
                Toast.makeText(context, "Please Enter Quantity", Toast.LENGTH_SHORT).show()
            }
            price.isEmpty() -> {
                Toast.makeText(context, "Please Enter Price", Toast.LENGTH_SHORT).show()
            }
            else -> {
                val groceryItems = GroceryItems(item, quantity.toInt(), price.toInt())
                dialogListener.onAddButtonClicked(groceryItems)
                dismiss()
            }
        }
    }
}