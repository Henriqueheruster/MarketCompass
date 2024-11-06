package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.example.marketcompass.R.layout.tela_mercados
import com.example.marketcompass.util.NetworkUtils
import com.example.marketcompass.util.api.Endpoint
import com.google.gson.JsonArray
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TelaMercado:Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        getMercado()
        val btnDoMercado : CardView = findViewById(R.id.mercado1)
        btnDoMercado.setOnClickListener{
            val intencao : Intent = Intent(this, TelaLista::class.java)
            startActivity(intencao)
        }
    }

    fun getMercado(){
        val retrofitClient = NetworkUtils.getRetrofitInstance("http://10.0.2.2:8181/")
        val endpoint = retrofitClient.create(Endpoint::class.java)

        endpoint.getMercado().enqueue(object : Callback<JsonArray>{

            override fun onResponse(call: Call<JsonArray>, response: Response<JsonArray>) {
                val data = mutableListOf<String>()


                Log.d("teste mercados", "Dados recebidos da API: ${data.joinToString(", ")}")
            }

            override fun onFailure(call: Call<JsonArray>, t: Throwable) {
                Log.e("Erro Retrofit", "Falha na requisição: ${t.message}")
                Toast.makeText(this@TelaMercado, "Não foi encontrado", Toast.LENGTH_SHORT).show()
            }
        })
        endpoint.getMercado()
    }
}