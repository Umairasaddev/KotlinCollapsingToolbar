package com.example.kotlincollapsingtoolbar.repository

import androidx.lifecycle.MutableLiveData
import com.example.kotlincollapsingtoolbar.api.PostsApi
import com.example.kotlincollapsingtoolbar.api.ProductsApi
import com.example.kotlincollapsingtoolbar.models.Posts
import com.example.kotlincollapsingtoolbar.util.Constants
import javax.inject.Inject

class PostsRepository @Inject constructor(private val postsService: PostsApi) {

    private val postsLiveData =  MutableLiveData<List<Posts>>()

    val posts: MutableLiveData<List<Posts>>
        get() = postsLiveData


    suspend fun getPosts() {
        val result = postsService.getPosts(Constants.BASE_POST_URL + "posts")
        if (result?.body() != null) {
            postsLiveData.postValue(result.body())
        }
    }
}