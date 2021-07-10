package com.rayhan.apptestscreening.ui.guest

import com.google.gson.annotations.SerializedName
import java.util.*

data class GuideModel(
    @SerializedName("image")
    val image: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("birthdate")
    val birthDate: Date
)
