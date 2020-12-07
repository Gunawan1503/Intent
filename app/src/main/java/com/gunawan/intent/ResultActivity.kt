package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    companion object{
        const val RESULT_CODE = 200
        const val EXTRA_COLOR = "extra_color"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        btn_hasil.setOnClickListener {
            if(rg_color.checkedRadioButtonId != 0) {
                var value = "#ffffff"
                when(rg_color.checkedRadioButtonId){
                    R.id.rad_merah -> value = "#ff0000"
                    R.id.rad_hitam -> value = "#000000"
                    R.id.rad_kuning -> value = "#ffff00"
                    R.id.rad_hijau -> value = "#00ff00"
                }
                Log.d("selected_color", value)

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_COLOR, value)
                setResult(RESULT_CODE, resultIntent)
                finish()
            }
        }
    }
}