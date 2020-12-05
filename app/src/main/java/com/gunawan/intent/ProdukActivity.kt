package com.gunawan.intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ProdukActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Produk"
        }
    }
}
