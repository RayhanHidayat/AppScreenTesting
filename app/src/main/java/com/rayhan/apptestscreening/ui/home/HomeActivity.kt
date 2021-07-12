package com.rayhan.apptestscreening.ui.home

import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.appcompat.app.AlertDialog
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
                val name = binding.etNama.text.toString()

                alertDialog(intent, name)
            }
        }
    }

    private fun alertDialog(intent: Intent, name: String) {
        val builder = AlertDialog.Builder(this)
        var isPalindrome = "Not Palindrome"

        if (isPalindrome(name)) isPalindrome = "isPalindrome"

        builder.setTitle("is palindrome?")
        builder.setMessage(isPalindrome)
        builder.setPositiveButton("Ok") { _: DialogInterface, _: Int ->
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            startActivity(intent)
        }
        builder.show()
    }

    private fun isPalindrome(text: String): Boolean {
        val normalText = text.filter { !it.isWhitespace() }
        val reversedText = normalText.reversed()

        if (normalText.contentEquals(reversedText) && !normalText.contentEquals("")) {
            return true
        }

        return false
    }
}