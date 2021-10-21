package com.example.hbapplicationgroupa.model.hotelmodule.allhotels


import com.google.gson.annotations.SerializedName

data class PageItem(
    @SerializedName("address")
    val address: String?,
    @SerializedName("city")
    val city: String?,
    @SerializedName("description")
    val description: String?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("featuredImage")
    val featuredImage: String?,
    @SerializedName("gallery")
    val gallery: List<String>?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("rating")
    val rating: Double?,
    @SerializedName("roomTypes")
    val roomTypes: List<RoomType>?,
    @SerializedName("state")
    val state: String?
)