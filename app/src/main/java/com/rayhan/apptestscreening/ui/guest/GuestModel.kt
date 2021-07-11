package com.rayhan.apptestscreening.ui.guest

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class GuestModel(
    @SerializedName("image")
    var image: String?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("birthdate")
    val birthDate: Date
) : Parcelable
