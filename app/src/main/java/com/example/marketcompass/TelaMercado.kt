package com.example.marketcompass

import android.app.Activity
import android.os.Bundle
import com.example.marketcompass.R.layout.tela_mercados

class TelaMercado:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
    }
}