package com.example.ecommerce_shoppingapp
/**
 * Chukwuemeka Emmanuel Obasi 23606
 */
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codingstuff.loginandsignup.shoppingCart
import com.example.ecommerce_shoppingapp.model.Product
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter:RecyclerView.Adapter<ProductAdapter.ViewHolder>? = null

    lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //login shared preference. logout handler
        preferences = getSharedPreferences("SHARED_PREF",Context.MODE_PRIVATE)

        val logout = findViewById<Button>(R.id.button)
        val nameTv = findViewById<TextView>(R.id.textView3)
        //val welcome = findViewById<TextView>(R.id.textView2)

        val name = preferences.getString("NAME","")
        nameTv.text = name

        logout.setOnClickListener {
            val editor: SharedPreferences.Editor = preferences.edit()
            editor.clear()
            editor.apply()

            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish()

            //setting up recycler view

            //discountedRecycler.apply{
            //    layoutManager = LinearLayoutManager(this@MainActivity)
             //   adapter = ProductAdapter()
              //  discountedRecycler.adapter = adapter
            //}
        }

        val imageButton = findViewById<ImageButton>(R.id.imageButton)
        imageButton.setOnClickListener {

            val intent = Intent( this, MainActivity2::class.java)
            startActivity((intent))
        }

        val shoppingCartButton = findViewById<ImageButton>(R.id.imageView2)
        shoppingCartButton.setOnClickListener {

            val intent = Intent (this, shoppingcart::class.java)
            startActivity(intent)
        }

        val imageButton2 = findViewById<ImageButton>(R.id.imageButton2)
        imageButton2.setOnClickListener {

            val intent = Intent (this, MainActivity3::class.java)
            startActivity(intent)
        }

    }

}