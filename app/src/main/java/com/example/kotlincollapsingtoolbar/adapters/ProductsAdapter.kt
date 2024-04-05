package com.example.kotlincollapsingtoolbar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincollapsingtoolbar.R
import com.example.kotlincollapsingtoolbar.models.ProductsModel

class ProductsAdapter(var products:List<ProductsModel>):RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val title :TextView = itemView.findViewById(R.id.titleTv)
        val description :TextView= itemView.findViewById(R.id.descriptonTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.products_item,parent,false))
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
      val products = products[position]

        holder.title.text = products.title
        holder.description.text = products.description
    }

    fun updateProducts(newProducts: List<ProductsModel>) {
        products = newProducts
        notifyDataSetChanged() // Notify RecyclerView that the dataset has changed
    }
}