package com.example.ecommerce_shoppingapp
/**
 * Chukwuemeka Emmanuel Obasi 23606
 */

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

class ProductDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.product_details)
    }
}