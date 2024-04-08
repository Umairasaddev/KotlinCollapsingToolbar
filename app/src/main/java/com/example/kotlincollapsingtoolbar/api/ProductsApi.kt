package com.example.kotlincollapsingtoolbar.api

import com.example.kotlincollapsingtoolbar.models.ProductsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface ProductsApi {
    @GET
    suspend fun getProducts(@Url product: String): Response<List<ProductsModel>>


}