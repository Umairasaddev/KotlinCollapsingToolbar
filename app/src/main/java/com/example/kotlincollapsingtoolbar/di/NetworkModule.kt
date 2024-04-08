package com.example.kotlincollapsingtoolbar.di

import com.example.kotlincollapsingtoolbar.api.PostsApi
import com.example.kotlincollapsingtoolbar.api.ProductsApi
import com.example.kotlincollapsingtoolbar.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getProductsApi(retrofit: Retrofit): ProductsApi {
        return retrofit.create(ProductsApi::class.java)
    }

    @Singleton
    @Provides
    fun getPostApi(retrofits: Retrofit): PostsApi {
        return retrofits.create(PostsApi::class.java)
    }


}