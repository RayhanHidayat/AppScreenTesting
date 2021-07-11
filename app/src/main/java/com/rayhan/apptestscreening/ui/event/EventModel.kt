package com.rayhan.apptestscreening.ui.event

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.*

@Parcelize
data class EventModel(
    val image: String,
    val nameEvent: String,
    val date: Date
) : Parcelable
