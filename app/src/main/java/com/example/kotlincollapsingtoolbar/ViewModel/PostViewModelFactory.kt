package com.example.kotlincollapsingtoolbar.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincollapsingtoolbar.repository.PostsRepository

class PostViewModelFactory (private val repository: PostsRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostsViewModel(repository) as T
    }
}