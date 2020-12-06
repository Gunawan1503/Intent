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
            val simpleintent = Intent(this@MainActivity, ProfileActivity::class.java)
            startActivity(simpleintent)
        }

        btn_view_produk.setOnClickListener{
            val withdata = Intent(this@MainActivity, ProdukActivity::class.java)
            withdata.putExtra(ProdukActivity.EXTRA_STOK, "20")
            withdata.putExtra(ProdukActivity.EXTRA_MEREK, "Novasion")
            withdata.putExtra(ProdukActivity.EXTRA_FROM, "Import")
            withdata.putExtra(ProdukActivity.EXTRA_WHERE, "Kota Bandung, Jawa Barat")
            startActivity(withdata)
        }

        btn_view_produk_parcel.setOnClickListener{
            val withparcel = Intent(this@MainActivity, ProdukParcelActivity::class.java)
            val user = User(20, "Novasion", "Import", "Kota Bandung, Jawa Barat")
            withparcel.putExtra(ProdukParcelActivity.EXTRA_USER, user)
            startActivity(withparcel)
        }

        btn_implisit.setOnClickListener {
            val phonenumber = "089636061434"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phonenumber"))
            startActivity(intent)
        }

        btn_result.setOnClickListener {
            val intent = Intent(this@MainActivity, ResultActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == 200){
            val color = data?.getStringExtra(ResultActivity.EXTRA_COLOR)
            Log.d("Color", color.toString())
            view_background.setBackgroundColor(Color.parseColor(color))
        }
    }
}
