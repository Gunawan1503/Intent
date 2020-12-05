package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_view_profile.setOnClickListener{
            val simpleintent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(simpleintent)
        }

        btn_view_produk.setOnClickListener{
            val withdata = Intent(this@MainActivity, ProdukActivity::class.java)
            startActivity(withdata)
        }

    }
}
