package com.example.gofit.retrofit.profile

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class PasswordRequest {
    @SerializedName("passwordBaru")
    @Expose
    var passwordBaru: String? = null
}