package com.rayhan.apptestscreening.ui.home

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
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
                val name = binding.etNama.editText?.text.toString()

                alertDialog(intent, name)
            }
        }
    }

    private fun alertDialog(intent: Intent, name: String) {
        val builder = AlertDialog.Builder(this)

        builder.setTitle("is palindrome?")
        builder.setMessage(isPalindrome(name))
        builder.setPositiveButton("Ok") { _: DialogInterface, _: Int ->
            intent.putExtra(MainActivity.EXTRA_NAME, name)
            startActivity(intent)
        }
        builder.show()
    }

    private fun isPalindrome(text: String): String {
        val normalText = text.filter { !it.isWhitespace() }
        val reversedText = normalText.reversed()

        if (normalText.contentEquals(reversedText)) {
            return "isPalindrome"
        }

        return "not palindrome"
    }
}