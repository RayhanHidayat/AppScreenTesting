package com.rayhan.apptestscreening.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.rayhan.apptestscreening.databinding.ActivityHomeBinding
import com.rayhan.apptestscreening.ui.main.MainActivity

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNext.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v) {
            binding.btnNext -> {
                val intent = Intent(this, MainActivity::class.java)
                val name = binding.etNama.editText?.text.toString()

                intent.putExtra(MainActivity.EXTRA_NAME, name)
                startActivity(intent)
            }
        }
    }
}