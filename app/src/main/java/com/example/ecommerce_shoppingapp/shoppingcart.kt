package com.example.ecommerce_shoppingapp

/**
 * Chukwuemeka Emmanuel Obasi 23606
 */

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView

var countorder = 0
var count = 0
class shoppingcart : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoppingcart)




        var ordercart = findViewById<TextView>(R.id.orderCart)


        var textview = findViewById<TextView>(R.id.textview)

        var addbutton = findViewById<View>(R.id.addbutton)
        addbutton.setOnClickListener {

            count++
            textview.text = count.toString()


        }

        var minusButton = findViewById<View>(R.id.removeButton)
        minusButton.setOnClickListener {

            count--
            textview.text = count.toString()

        }

        var orderbutton = findViewById<View>(R.id.oderButton)
        orderbutton.setOnClickListener {

            countorder = count
            ordercart.text = countorder.toString()

        }


        val mainText: TextView = findViewById(R.id.main_text)
        val mainImage: ImageView = findViewById(R.id.main_image)
        val newsText: TextView = findViewById(R.id.newsText)

        val bundle: Bundle? = intent.extras

        val title = bundle!!.getString("title")
        val image = bundle.getInt("image")
        val price = bundle.getString("price")

        mainText.text = title
        newsText.text = price
        mainImage.setImageResource(image)

        val backhome = findViewById<TextView>(R.id.backhome)
        backhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }


}
