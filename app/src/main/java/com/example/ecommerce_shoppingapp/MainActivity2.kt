package com.example.ecommerce_shoppingapp
/**
 * Chukwuemeka Emmanuel Obasi 23606
 */
import com.codingstuff.loginandsignup.shoppingCart


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ecommerce_shoppingapp.ProductAdapter
import com.example.ecommerce_shoppingapp.R
import com.example.ecommerce_shoppingapp.formate


class MainActivity2 : AppCompatActivity() {

    private lateinit var newRecyclerView: RecyclerView
    private lateinit var newArrayList: ArrayList<formate>
    private lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var price: Array<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        image = arrayOf(
            R.drawable.imagea,
            R.drawable.imageb,
            R.drawable.imagec,
            R.drawable.imaged

            )

        title = arrayOf(
            "Heads and sholders",
            "Anti dirt spray",
            "Toilet soap",
            "cleaning set"


        )
        price= arrayOf(
            "$20",
            "$30",
            "$22",
            "$100"
        )



        newRecyclerView = findViewById(R.id.recyclerview)

        newRecyclerView.layoutManager = LinearLayoutManager(this)
        newRecyclerView.setHasFixedSize(true)
        newArrayList = arrayListOf<formate>()
        getUserData()

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.setOnClickListener {
            val intent = Intent (this, ProductDetails::class.java)
            startActivity(intent)
        }


    }

    private fun getUserData() {
        for (i in image.indices) {
            val info = formate(image[i], title[i],price[i])
            newArrayList.add(info)
        }

        var adapter = ProductAdapter(newArrayList)

        newRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : ProductAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                //  Toast.makeText(this@MainActivity,"You clicked. $position", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity2, shoppingcart::class.java)
                intent.putExtra("title", newArrayList[position].title)
                intent.putExtra("image", newArrayList[position].image)
                intent.putExtra("price", price[position])
                startActivity(intent)


            }

        })
    }



}
