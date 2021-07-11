package com.rayhan.apptestscreening.ui.event

import java.text.SimpleDateFormat
import java.util.*

object EventDataList {
    fun generateEventData(): MutableList<EventModel> {
        val data = mutableListOf<EventModel>()

        data.add(
            EventModel(
                "https://adbalon.com/blog/wp-content/uploads/2020/05/mch-group-live-marketing-aktivierung.jpg",
                "ABC Event",
                "21 Februari 2021"
            )
        )
        data.add(
            EventModel(
                "https://uprint.id/blog/wp-content/uploads/2019/06/cara-mempersiapkan-event.jpg",
                "DEF Event",
                "12 Maret 2021"
            )
        )
        data.add(
            EventModel(
                "https://kumahakonveksi.com/po-content/uploads/maxresdefault.jpg",
                "GHJ Event",
                "25 Maret 2021"
            )
        )
        data.add(
            EventModel(
                "https://sasanadigital.com/wp-content/uploads/2020/12/Tips-Memilih-Webinar-Untuk-Menambah-Pengetahuan-Anda-e1608747377828-1280x691.png",
                "OPQ Event",
                "01 Juli 2021"
            )
        )
        data.add(
            EventModel(
                "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1532922691/Event_terpopuler_syag8e.jpg",
                "XYZ Event",
                "24 Agustus 2021"
            )
        )


        return data
    }
}