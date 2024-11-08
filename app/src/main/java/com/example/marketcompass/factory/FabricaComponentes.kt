package com.example.marketcompass.factory

import android.app.Activity
import android.content.Context

abstract class FabricaComponentes {

    abstract val ctx: Context


    fun  desenhar(){
        val c : Componente = criarComponente()
        c.desenhar()
    }
    abstract fun  criarComponente(): Componente

}