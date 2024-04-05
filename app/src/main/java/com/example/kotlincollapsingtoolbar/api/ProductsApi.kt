package com.example.kotlincollapsingtoolbar.api

import com.example.kotlincollapsingtoolbar.models.ProductsModel
import retrofit2.Response
import retrofit2.http.GET


interface ProductsApi {
    @GET("products")
    suspend fun getProducts():Response<List<ProductsModel>>
}