package com.example.ecommerce_shoppingapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
/**
 * Chukwuemeka Emmanuel Obasi 23606
 */
class LoginActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var isRemembered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        isRemembered = sharedPreferences.getBoolean("CHECKBOX",false)

        if (isRemembered){
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        val login = findViewById<Button>(R.id.login)
        val name = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val checkbox = findViewById<CheckBox>(R.id.checkBox)


        login.setOnClickListener {
            val name : String = name.text.toString()
            val password : String = password.text.toString()
            val checkbox : Boolean = checkbox.isChecked

            val editor:SharedPreferences.Editor = sharedPreferences.edit()
            editor.putString("NAME",name)
            editor.putString("PASSWORD", password)
            editor.putBoolean("CHECKBOX", checkbox)
            editor.apply()

            Toast.makeText(this,"information Saved", Toast.LENGTH_LONG).show()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}