package com.example.marketcompass

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.marketcompass.R.layout.tela_mercados
import com.example.marketcompass.createCompenents.MarketAdapter
import com.example.marketcompass.createCompenents.MarketViewHolder
import com.example.marketcompass.dados.mercados
import com.example.marketcompass.util.NetworkUtils
import com.example.marketcompass.util.api.Endpoint
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class TelaMercado:Activity() {

    private var listaMercados: MutableList<mercados> = mutableListOf()
    private lateinit var marketRecyclerView: RecyclerView
    private lateinit var marketAdapter: MarketAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(tela_mercados)
        Log.d("Retorno",getMercado().toString())
        Log.d("Atributo",listaMercados.toString())

        marketRecyclerView = findViewById(R.id.marketRecyclerView)
        marketRecyclerView.layoutManager = LinearLayoutManager(this)

        val btnDoMercado : ScrollView = findViewById(R.id.PAIDOTREM)
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

                if (response.isSuccessful) {

                    val mercados = response.body() ?: listOf()
                    marketAdapter = MarketAdapter(mercados)
                    marketRecyclerView.adapter = marketAdapter
                }

               val paidotrem : ScrollView = findViewById(R.id.PAIDOTREM)
                val trem : ViewHolder? = marketRecyclerView.adapter!!?.onCreateViewHolder(paidotrem,1)

                for (i in 0..response.body()!!.count()){
                    trem
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