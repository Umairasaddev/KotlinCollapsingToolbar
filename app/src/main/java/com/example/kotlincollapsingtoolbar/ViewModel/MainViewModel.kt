package com.example.kotlincollapsingtoolbar.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincollapsingtoolbar.models.ProductsModel
import com.example.kotlincollapsingtoolbar.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: ProductsRepository): ViewModel(){

    init {
//        viewModelScope.launch(Dispatchers.IO){
//            repository.getProducts()
////            repository ny live data main response lia from QuotesRepository or view model main pass kar dia
//        }

    }

    init {
        viewModelScope.launch (Dispatchers.IO ){
            repository.getProducts()
        }

    }

    val products: LiveData<List<ProductsModel>>
        get() = repository.products
}