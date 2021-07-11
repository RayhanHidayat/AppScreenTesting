package com.rayhan.apptestscreening.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.rayhan.apptestscreening.databinding.ActivityMainBinding
import com.rayhan.apptestscreening.ui.event.EventActivity
import com.rayhan.apptestscreening.ui.event.EventModel
import com.rayhan.apptestscreening.ui.guest.GuestActivity
import com.rayhan.apptestscreening.ui.guest.GuestModel
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = ""
    }

    private lateinit var binding: ActivityMainBinding
    private var dataEvent: EventModel? = null
    private var dataGuest: GuestModel? = null

    private val activityResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == 111)
                dataEvent = it.data?.getParcelableExtra("event")
            else if (it.resultCode == 112)
                dataGuest = it.data?.getParcelableExtra("guest")
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var name = intent.getStringExtra(EXTRA_NAME)

        if (name.contentEquals("")) name = "Default"


        binding.tvNamaDimasukkan.text = name
        binding.btnEvent.setOnClickListener(this)
        binding.btnGuest.setOnClickListener(this)

    }

    override fun onResume() {
        super.onResume()

        if (dataEvent != null) binding.btnEvent.text = dataEvent!!.nameEvent

        if (dataGuest != null) {
            val displayDateFormat = SimpleDateFormat("dd MMM yyyy", Locale.US)

            binding.btnGuest.text = dataGuest!!.name
            val tgl = displayDateFormat.format(dataGuest!!.birthDate)
            val hariLahir = tgl.toString().slice(0..1).toInt()
            @Suppress("DEPRECATION") val blnLahir = dataGuest!!.birthDate.month

            cariKelipatan(hariLahir)
            cariAngkaPrima(blnLahir)
        }
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnEvent -> {
                val intent = Intent(this, EventActivity::class.java)
                activityResult.launch(intent)
            }
            binding.btnGuest -> {
                val intent = Intent(this, GuestActivity::class.java)
                activityResult.launch(intent)
            }
        }
    }

    private fun cariKelipatan(hariLahir: Int) {

        if (hariLahir % 2 == 0 && hariLahir % 3 == 0)
            Toast.makeText(this, "iOS", Toast.LENGTH_SHORT).show()
        else if (hariLahir % 3 == 0)
            Toast.makeText(this, "android", Toast.LENGTH_SHORT).show()
        else if (hariLahir % 2 == 0)
            Toast.makeText(this, "blackberry", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "feature phone", Toast.LENGTH_SHORT).show()

    }

    private fun cariAngkaPrima(blnLahir: Int) {
        val angka = blnLahir + 1
        var prima = true

        if (angka == 1)
            prima = false
        else
            for (i in 2..angka / 2) {
                if (angka % i == 0) {
                    prima = false
                    break
                }
            }

        if (prima)
            Toast.makeText(this, "Bilangan Prima", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(this, "Bukan Bilangan Prima", Toast.LENGTH_SHORT).show()
    }
}