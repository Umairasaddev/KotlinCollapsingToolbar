package com.example.kotlincollapsingtoolbar.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincollapsingtoolbar.R
import com.example.kotlincollapsingtoolbar.ViewModel.MainViewModel
import com.example.kotlincollapsingtoolbar.adapters.ProductsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class FirstFragment : Fragment() {

    lateinit var mainViewModel: MainViewModel
    lateinit var adapter: ProductsAdapter
    lateinit var productRV: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        productRV = view.findViewById(R.id.recyclerView)
        adapter = ProductsAdapter(emptyList())
        productRV.adapter = adapter

//        productRV.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        productRV.layoutManager = GridLayoutManager(context, 2)

        // Observe the LiveData for products
        mainViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            // Update the adapter's dataset when the product list changes
            Log.d("umair", "onViewCreated: " + products.toString())
            adapter.updateProducts(products)
        })


//        mainViewModel.products.observe(viewLifecycleOwner, Observer {
//            Log.d("umair", "onViewCreated: " + it.toString())
//        })

    }


}








