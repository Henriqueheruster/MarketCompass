package com.example.marketcompass

import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.marketcompass.R.layout.tela_mercados
import com.example.marketcompass.dados.mercados
import com.example.marketcompass.factory.FabricaCards
import com.example.marketcompass.util.NetworkUtils
import com.example.marketcompass.util.api.Endpoint
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TelaMercado:Activity() {

    private var listaMercados: MutableList<mercados> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        val paiCards = findViewById<LinearLayout>(R.id.paiMercados)
        val fb_cards = FabricaCards(this@TelaMercado,mercados(1,"incrivel", "url"), paiCards)
        fb_cards.desenhar()
        fb_cards.setMercado(mercados(2, "shooooow", "C:/Users/User01/Pictures/patonautaaaaaa.jpg"))
        fb_cards.desenhar()
        fb_cards.desenhar()
        fb_cards.desenhar()
        fb_cards.desenhar()
        fb_cards.desenhar()


    }

    fun getMercado(): Call<MutableList<mercados>> {
        val retrofitClient = NetworkUtils.getRetrofitInstance("http://10.0.2.2:8181/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getMercado().enqueue(object : Callback<MutableList<mercados>>{

            override fun onResponse(call: Call<MutableList<mercados>>, response: Response<MutableList<mercados>>) {
                var  tela :ConstraintLayout = findViewById(R.id.tela_mercados)
                var cardAtual: CardView

                var imgAtual : ImageView
                var  textoDoCardAtual : TextView

                //colocar mercados na tela
                for (i in 0..response.body()!!.count()){
                    cardAtual = CardView(this@TelaMercado )



                    imgAtual = ImageView(this@TelaMercado)
                    textoDoCardAtual = TextView(this@TelaMercado)

                    cardAtual.addView(imgAtual)
                    cardAtual.addView(textoDoCardAtual)
                    tela.addView(cardAtual)
                }
            }

            override fun onFailure(call: Call<MutableList<mercados>>, t: Throwable) {
                Log.e("Erro Retrofit", "Falha na requisição: ${t.message}")
                Toast.makeText(this@TelaMercado, "Não foi encontrado", Toast.LENGTH_SHORT).show()
            }
        })
        return endpoint.getMercado()
    }
}