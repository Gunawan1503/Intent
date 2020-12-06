package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    companion object{
        const val RESULT_CODE = "result_code"
        const val EXTRA_COLOR = "extra_color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btn_result.setOnClickListener {
            if(rg_color.checkedRadioButtonId != 0) {
                var value = "#fff"
                when(rg_color.checkedRadioButtonId){
                    R.id.rad_merah -> value = "#f00"
                    R.id.rad_hitam -> value = "#000"
                    R.id.rad_kuning -> value = "#ff0"
                    R.id.rad_hijau -> value = "#0f0"
                }
                Log.d("selected_color", value.toString())

                val resultintent = Intent()
                resultintent.putExtra(EXTRA_COLOR, value)
                setResult(200, resultintent)
                finish()
            }
        }
    }
}