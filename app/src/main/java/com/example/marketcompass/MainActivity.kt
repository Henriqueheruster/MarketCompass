package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.bumptech.glide.Glide
import android.widget.ImageView
import com.example.marketcompass.R.layout.activity_main


class MainActivity : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        Handler().postDelayed({
            val acao = Intent(this, TelaComecar::class.java)
            startActivity(acao)
            finish()
        }, 1000)
    }

}