package com.example.hbapplicationgroupa.model.hotelmodule.gettopdeals

data class GetTopDealsResponseModel(
    val data: MutableList<GetTopDealsResponseItem>,
    val succeeded: Boolean,
    val message: String,
    val statusCode: String,
)
