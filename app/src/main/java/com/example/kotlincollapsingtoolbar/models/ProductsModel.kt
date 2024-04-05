package com.example.kotlincollapsingtoolbar.models

import com.google.gson.annotations.SerializedName

data class ProductsModel(

    @SerializedName("id") var id: Int? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("price") var price: Double? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("image") var image: String? = null,
    @SerializedName("rating") var rating: Rating? = Rating()

)

//  val id: Int,
//    val title: String,
//    val price: Double,
//    val description: String,
//    val category: String,
//    val image: String,
//    val rating: List<Rating>