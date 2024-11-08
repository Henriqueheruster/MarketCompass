package com.example.marketcompass.createCompenents

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marketcompass.R
import com.example.marketcompass.dados.mercados
import com.squareup.picasso.Picasso

class MarketAdapter (private val mercados: List<mercados>) : RecyclerView.Adapter<MarketViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.modelo_card, parent, false)
        return MarketViewHolder(view)
    }

    override fun onBindViewHolder(holder: MarketViewHolder, position: Int) {
        val mercado = mercados[position]
        holder.marketName.text = mercado.nome
        Picasso.get().load(mercado.imagem).into(holder.marketImage)
    }

    override fun getItemCount(): Int = mercados.size

}