package com.roomdatabase.mvvm.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.roomdatabase.mvvm.adapter.GroceryAdapter
import com.roomdatabase.mvvm.database.entity.GroceryItems
import com.roomdatabase.mvvm.databinding.ActivityMainBinding
import com.roomdatabase.mvvm.di.GroceryApplication
import com.roomdatabase.mvvm.viewmodel.GroceryViewModel
import com.roomdatabase.mvvm.viewmodel.GroceryViewModelFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: GroceryViewModel

    @Inject
    lateinit var factory: GroceryViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        (application as GroceryApplication).appComponent.inject(this)

        viewModel = ViewModelProvider(this, factory).get(GroceryViewModel::class.java)

        bindRecyclerView()
        clickListener()
    }

    private fun bindRecyclerView() {
        val groceryAdapter = GroceryAdapter(listOf(), viewModel)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = groceryAdapter

        viewModel.getAllGroceryItems().observe(this, Observer {
            groceryAdapter.list = it
            groceryAdapter.notifyDataSetChanged()
        })
    }

    private fun clickListener() {
        binding.btnAdd.setOnClickListener {
            GroceryItemDialog(this, object : DialogListener {
                override fun onAddButtonClicked(item: GroceryItems) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}