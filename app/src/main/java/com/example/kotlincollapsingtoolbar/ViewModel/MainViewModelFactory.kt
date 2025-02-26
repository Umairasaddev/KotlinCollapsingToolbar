package com.example.kotlincollapsingtoolbar.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlincollapsingtoolbar.repository.ProductsRepository

class MainViewModelFactory(private val repository: ProductsRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T

    }
}