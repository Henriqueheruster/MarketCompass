package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.example.marketcompass.R.layout.tela_comecar

class TelaComecar:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_comecar)

        val botaoIniciar : Button = findViewById(R.id.btnComecar)

        botaoIniciar.setOnClickListener {
            val acao = Intent(this, TelaMercado::class.java)
            startActivity(acao)
        }
    }
}