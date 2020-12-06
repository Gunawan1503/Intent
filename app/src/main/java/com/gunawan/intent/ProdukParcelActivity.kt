package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gunawan.intent.Model.User
import kotlinx.android.synthetic.main.activity_produk.*
import kotlinx.android.synthetic.main.activity_produk_parcel.*
import kotlinx.android.synthetic.main.activity_produk_parcel.btn_back
import kotlinx.android.synthetic.main.activity_produk_parcel.from_value
import kotlinx.android.synthetic.main.activity_produk_parcel.merek_value
import kotlinx.android.synthetic.main.activity_produk_parcel.stok_value
import kotlinx.android.synthetic.main.activity_produk_parcel.where_value

class ProdukParcelActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USER = "extra_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_produk_parcel)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Produk Parcelable"
        }

        val user = intent.getParcelableExtra<User>(EXTRA_USER) as User
        stok_value.text = user.stok.toString()
        merek_value.text = user.merek
        from_value.text = user.from
        where_value.text = user.where

        btn_back.setOnClickListener {
            val btnback = Intent(this@ProdukParcelActivity, MainActivity::class.java)
            startActivity(btnback)
        }
    }
}
