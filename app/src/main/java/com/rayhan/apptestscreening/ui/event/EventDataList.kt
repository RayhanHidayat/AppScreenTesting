package com.rayhan.apptestscreening.ui.event

import java.util.*

object EventDataList {
    fun generateEventData(): MutableList<EventModel> {
        val data = mutableListOf<EventModel>()

        data.add(
            EventModel(
                "https://adbalon.com/blog/wp-content/uploads/2020/05/mch-group-live-marketing-aktivierung.jpg",
                "ABC Event",
                Date(20210111)
            )
        )
        data.add(
            EventModel(
                "https://uprint.id/blog/wp-content/uploads/2019/06/cara-mempersiapkan-event.jpg",
                "DEF Event",
                Date(20210521)
            )
        )
        data.add(
            EventModel(
                "https://kumahakonveksi.com/po-content/uploads/maxresdefault.jpg",
                "GHJ Event",
                Date(20211015)
            )
        )
        data.add(
            EventModel(
                "https://sasanadigital.com/wp-content/uploads/2020/12/Tips-Memilih-Webinar-Untuk-Menambah-Pengetahuan-Anda-e1608747377828-1280x691.png",
                "OPQ Event",
                Date(20211123)
            )
        )
        data.add(
            EventModel(
                "https://blue.kumparan.com/image/upload/fl_progressive,fl_lossy,c_fill,q_auto:best,w_640/v1532922691/Event_terpopuler_syag8e.jpg",
                "XYZ Event",
                Date(20211214)
            )
        )


        return data
    }
}