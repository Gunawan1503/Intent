package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_produk.*

class ProdukActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STOK = "extra_stok"
        const val EXTRA_MEREK = "extra_merek"
        const val EXTRA_FROM = "extra_from"
        const val EXTRA_WHERE = "extra_where"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Produk"
        }

        stok_value.text = intent.getStringExtra(EXTRA_STOK)
        merek_value.text = intent.getStringExtra(EXTRA_MEREK)
        from_value.text = intent.getStringExtra(EXTRA_FROM)
        where_value.text = intent.getStringExtra(EXTRA_WHERE)
        
        btn_back.setOnClickListener{
            val backbutton = Intent(this@ProdukActivity, MainActivity::class.java)
            startActivity(backbutton)
        }
    }
}
