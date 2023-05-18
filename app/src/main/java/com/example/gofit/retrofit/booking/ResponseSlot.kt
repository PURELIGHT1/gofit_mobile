package com.example.gofit.retrofit.booking

import com.google.gson.annotations.SerializedName

class ResponseSlot {
    @SerializedName("status")
    var status: Int? = null

    @SerializedName("message")
    val message:String? = null

    @SerializedName("data")
    val data:Int? = null
}