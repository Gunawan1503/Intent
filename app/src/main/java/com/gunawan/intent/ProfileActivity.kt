package com.gunawan.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        if (supportActionBar != null) {
            supportActionBar!!.title = "Profile"
        }

        btn_follow.setOnClickListener{
            val btnBack = Intent(this@ProfileActivity, MainActivity::class.java)
            startActivity(btnBack)
        }

    }
}
