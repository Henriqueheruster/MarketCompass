package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.marketcompass.R.layout.tela_mercados

class TelaMercado:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        val btnDoMercado : CardView = findViewById(R.id.mercado1)
        btnDoMercado.setOnClickListener{
            val intencao : Intent = Intent(this, TelaLista::class.java)
            startActivity(intencao)
        }
    }
}