package com.example.kotlincollapsingtoolbar.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincollapsingtoolbar.R
import com.example.kotlincollapsingtoolbar.ViewModel.PostsViewModel
import com.example.kotlincollapsingtoolbar.adapters.PostsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : Fragment() {

    lateinit var postViewModel: PostsViewModel
    lateinit var postsAdapter: PostsAdapter
    lateinit var rvPosts: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        postViewModel = ViewModelProvider(this)[PostsViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvPosts = view.findViewById(R.id.rvPosts)
        postsAdapter = PostsAdapter(emptyList())
        rvPosts.adapter = postsAdapter

        rvPosts.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        postViewModel.posts.observe(viewLifecycleOwner, Observer { posts ->
            Log.d("umair", "onViewCreated for posts: " + posts.toString())
            postsAdapter.updatePosts(posts)
        })

    }
}









