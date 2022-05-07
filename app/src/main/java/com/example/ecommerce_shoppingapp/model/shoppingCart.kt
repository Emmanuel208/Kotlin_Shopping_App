package com.codingstuff.loginandsignup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.ecommerce_shoppingapp.MainActivity
import com.example.ecommerce_shoppingapp.R

var countorder = 0
var count = 0
class shoppingCart : AppCompatActivity() {
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

        val heading = bundle!!.getString("heading")
        val imageId = bundle.getInt("imageId")
        val news = bundle.getString("news")

        mainText.text = heading
        newsText.text = news
        mainImage.setImageResource(imageId)

        val backhome = findViewById<TextView>(R.id.backhome)
        backhome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}