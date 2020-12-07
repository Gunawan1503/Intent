package com.gunawan.intent

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.gunawan.intent.Model.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_view_profile.setOnClickListener{
            val simpleIntent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(simpleIntent)
        }

        btn_view_produk.setOnClickListener{
            val withData = Intent(this@MainActivity, ProdukActivity::class.java)
            withData.putExtra(ProdukActivity.EXTRA_STOK, "20")
            withData.putExtra(ProdukActivity.EXTRA_MEREK, "Novasion")
            withData.putExtra(ProdukActivity.EXTRA_FROM, "Import")
            withData.putExtra(ProdukActivity.EXTRA_WHERE, "Kota Bandung")
            startActivity(withData)
        }

        btn_view_produk_parcel.setOnClickListener{
            val withParcel = Intent(this@MainActivity, ProdukParcelActivity::class.java)
            val user = User(20, "Novasion", "Import", "Kota Bandung")
            withParcel.putExtra(ProdukParcelActivity.EXTRA_USER, user)
            startActivity(withParcel)
        }

        btn_implisit.setOnClickListener {
            val phoneNumber = "089636061434"
            val moveIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
            startActivity(moveIntent)
        }

        btn_result.setOnClickListener {
            val resultIntent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(resultIntent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_background.setBackgroundColor(Color.parseColor(color.toString()))
        }
    }
}
