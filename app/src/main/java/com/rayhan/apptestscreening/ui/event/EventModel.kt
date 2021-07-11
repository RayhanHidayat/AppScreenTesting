package com.rayhan.apptestscreening.ui.event

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EventModel(
    val image: String,
    val nameEvent: String,
    val date: String
) : Parcelable
