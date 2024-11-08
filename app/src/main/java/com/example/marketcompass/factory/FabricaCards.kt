package com.example.marketcompass.factory

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.constraintlayout.widget.ConstraintSet.Layout
import com.example.marketcompass.dados.mercados

class FabricaCards(override val ctx: Context, var mrcd : mercados, val paiCards: LinearLayout) : FabricaComponentes() {

    override fun criarComponente(): Componente {
        return ComponenteCardView(ctx, mrcd, paiCards)
     }

    fun  setMercado(mrcd: mercados){
        this@FabricaCards.mrcd = mrcd
    }

 }