package com.example.edittext

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var editTextUsername: EditText? = null
    private var editTextPassword: EditText? = null
    private var buttonConfirm: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextUsername = findViewById(R.id.edit_text_username)
        editTextPassword = findViewById(R.id.edit_text_password)
        buttonConfirm = findViewById(R.id.button_confirm)

        editTextUsername?.run { addTextChangedListener(loginTextWatcher) }
        editTextPassword?.run { addTextChangedListener(loginTextWatcher) }
    }
    private val loginTextWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {

        }

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val usernameInput = editTextUsername!!.text.toString().trim()
            val passwordInput = editTextPassword!!.text.toString().trim()

            buttonConfirm!!.isEnabled = !usernameInput.isEmpty() && !passwordInput.isEmpty()
        }

        override fun afterTextChanged(editable: Editable) {

        }
    }
}