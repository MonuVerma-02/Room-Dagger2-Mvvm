package com.roomdatabase.mvvm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.roomdatabase.mvvm.R
import com.roomdatabase.mvvm.database.entity.GroceryItems
import com.roomdatabase.mvvm.viewmodel.GroceryViewModel
import kotlinx.android.synthetic.main.recycler_item_view.view.*

class GroceryAdapter(var list: List<GroceryItems>, val viewModel: GroceryViewModel) :
    RecyclerView.Adapter<GroceryAdapter.GroceryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroceryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item_view, parent, false)
        return GroceryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: GroceryViewHolder, position: Int) {
        var currentPosition = list[position]
        holder.itemView.txtItemName.text = currentPosition.itemName
        holder.itemView.txtItemPrice.text = "${currentPosition.itemPrice}"
        holder.itemView.txtItemQuantity.text = "Qty:${currentPosition.itemQuantity}"

        holder.itemView.imgDelete.setOnClickListener {
            viewModel.delete(currentPosition)
        }

        //To get total cost
        if (position == list.size - 1) {
            var totalCost = 0
            for (element in list) {
                totalCost += element.itemPrice
            }
            holder.itemView.txtItemTotalCost.visibility = View.VISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.VISIBLE
            holder.itemView.txtItemTotalCost.text = "$totalCost"

        } else {
            holder.itemView.txtItemTotalCost.visibility = View.INVISIBLE
            holder.itemView.txtTotalCostTitle.visibility = View.INVISIBLE
        }

    }

    inner class GroceryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}