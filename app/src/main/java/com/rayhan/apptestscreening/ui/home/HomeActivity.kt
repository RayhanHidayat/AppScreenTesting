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
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
            window.insetsController?.let {
                it.hide(WindowInsets.Type.statusBars() or WindowInsets.Type.navigationBars())
                it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            }
        } else {
            @Suppress("DEPRECATION")
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION)
        }

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