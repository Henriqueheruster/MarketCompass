package com.example.marketcompass.factory

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.example.marketcompass.dados.mercados

class ComponenteCardView(val ctx: Context, val mrcd: mercados, val paiCards: LinearLayout) : Componente {

    override fun desenhar() {
        var crdViw = CardView(ctx)
        var imgVw =ImageView(ctx)
        var txtVw =TextView(ctx)

        txtVw.text = mrcd.nome
        Uri.Builder().path(mrcd.imagem)
        imgVw.setImageURI(Uri.Builder().build())

        Log.d("url", Uri.Builder().build().toString())

        crdViw.addView(imgVw)
        crdViw.addView(txtVw)
        paiCards.addView(crdViw)
    }
}