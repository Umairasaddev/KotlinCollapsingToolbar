package com.example.kotlincollapsingtoolbar.api

import com.example.kotlincollapsingtoolbar.models.Posts
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface PostsApi {

    @GET
    suspend fun getPosts(@Url post:String): Response<List<Posts>>
}