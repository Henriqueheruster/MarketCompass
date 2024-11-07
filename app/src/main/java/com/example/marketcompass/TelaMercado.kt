package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.marketcompass.R.layout.tela_mercados
import com.example.marketcompass.dados.mercados
import com.example.marketcompass.util.NetworkUtils
import com.example.marketcompass.util.api.Endpoint
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TelaMercado:Activity() {

    private var listaMercados: MutableList<mercados> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        Log.d("Retorno",getMercado().toString())
        Log.d("Atributo",listaMercados.toString())
        val btnDoMercado : CardView = findViewById(R.id.mercado1)
        btnDoMercado.setOnClickListener{
            val intencao : Intent = Intent(this, TelaLista::class.java)
            startActivity(intencao)
        }
    }

    fun getMercado(): Call<MutableList<mercados>> {
        val retrofitClient = NetworkUtils.getRetrofitInstance("http://10.0.2.2:8181/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getMercado().enqueue(object : Callback<MutableList<mercados>>{

            override fun onResponse(call: Call<MutableList<mercados>>, response: Response<MutableList<mercados>>) {
                var  tela :ConstraintLayout = findViewById(R.id.tela_mercados)
                var cardAtual: CardView
                var cardModelo : CardView = findViewById(R.id.mercado1)
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