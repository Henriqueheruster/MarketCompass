package com.example.marketcompass.createCompenents

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.marketcompass.R

class MarketViewHolder(view: View): RecyclerView.ViewHolder(view) {
    val marketImage: ImageView = view.findViewById(R.id.imgMercado1)
    val marketName: TextView = view.findViewById(R.id.modelTextView)
}