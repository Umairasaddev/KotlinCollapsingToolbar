package com.example.kotlincollapsingtoolbar.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincollapsingtoolbar.R
import com.example.kotlincollapsingtoolbar.models.Posts
import com.example.kotlincollapsingtoolbar.models.ProductsModel

class PostsAdapter(var posts: List<Posts>) : RecyclerView.Adapter<PostsAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val title: TextView = itemView.findViewById(R.id.titlePostsTv)
        val body: TextView = itemView.findViewById(R.id.bodyPostsTv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.posts_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val posts = posts[position]
        holder.title.text = posts.title
        holder.body.text = posts.body
    }

    fun updatePosts(newPosts: List<Posts>) {
        posts = newPosts
        notifyDataSetChanged() // Notify RecyclerView that the dataset has changed
    }
}