package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.marketcompass.R.layout.tela_mercados
import com.example.marketcompass.util.NetworkUtils
import com.example.marketcompass.util.api.Endpoint
import com.google.gson.JsonObject
import retrofit2.Call

import retrofit2.Response

class TelaMercado:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        val btnDoMercado : CardView = findViewById(R.id.mercado1)
        getMercado();
        btnDoMercado.setOnClickListener{

            val intencao : Intent = Intent(this, TelaLista::class.java)

            startActivity(intencao)
        }
    }

    fun getMercado(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("http://localhost:8181")
        val endpoint = retrofitClient.create(Endpoint::class.java)



        endpoint.getMercado("").enqueue(object :

        retrofit2.Callback<JsonObject>{

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val data = mutableListOf<String>()

                response.body()?.keySet()?.iterator()?.forEach{
                    data.add(it)
                }

                println(data.count())
            }

            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                print("Não foi encontrado!")
            }
        })
    }
}