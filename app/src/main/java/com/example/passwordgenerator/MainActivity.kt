package com.example.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.floor
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        buttonSubmit.setOnClickListener {
            val passwordLength = editTextPasswordLength.text.toString().toIntOrNull()
            val password = passwordLength?.let { it1 -> generatePassword(it1) }

            textViewGeneratedPass.text = password
        }
    }

    private fun generatePassword(passwordLength: Int): String {
        val chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
        var password = ""

        for(i in 0 until passwordLength){
            password += chars[floor(Math.random() * chars.length).toInt()]
        }

        return password
    }
}
