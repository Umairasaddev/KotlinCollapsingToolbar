package com.example.kotlincollapsingtoolbar.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.kotlincollapsingtoolbar.api.ProductsApi
import com.example.kotlincollapsingtoolbar.models.ProductsModel
import javax.inject.Inject

class ProductsRepository @Inject constructor(private val productsApi:ProductsApi) {

    private val producstLiveData = MutableLiveData<List<ProductsModel>>()
    val products:LiveData<List<ProductsModel>>
        get() = producstLiveData

   suspend fun getProducts(){
        val result = productsApi.getProducts()
        if(result?.body() !=null){

            producstLiveData.postValue(result.body())

        }
    }
}


