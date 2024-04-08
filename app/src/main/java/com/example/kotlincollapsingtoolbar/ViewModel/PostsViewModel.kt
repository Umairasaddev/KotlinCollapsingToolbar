package com.example.kotlincollapsingtoolbar.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlincollapsingtoolbar.models.Posts
import com.example.kotlincollapsingtoolbar.repository.PostsRepository
import com.example.kotlincollapsingtoolbar.repository.ProductsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(private val repository: PostsRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getPosts()
        }
    }

    val posts:LiveData<List<Posts>>
        get() = repository.posts

}