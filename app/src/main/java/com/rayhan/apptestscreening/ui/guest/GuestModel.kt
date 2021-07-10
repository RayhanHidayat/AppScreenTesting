package com.rayhan.apptestscreening.ui.guest

import com.google.gson.annotations.SerializedName
import java.util.*

data class GuestModel(
    @SerializedName("image")
    var image: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("birthdate")
    val birthDate: Date
)
