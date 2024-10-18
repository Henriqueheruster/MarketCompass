package com.example.marketcompass

import android.app.Activity
import android.os.Bundle
import com.example.marketcompass.R.layout.tela_lista_produto
import android.content.Intent
import android.widget.Button


class TelaLista : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_lista_produto)

        val btnLocalizar : Button = findViewById(R.id.localizar)

        btnLocalizar.setOnClickListener{
            val intencao : Intent =  Intent(this,TelaBussola::class.java)
            startActivity(intencao)
        }
    }
}