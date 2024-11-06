package com.example.marketcompass.util.api

import com.example.marketcompass.dados.mercados
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface Endpoint {
    @GET("/mercadosJson/{from}")
    fun getMercado(@Path(value = "from", encoded = true)from:String) : Call<JsonObject>

    @GET("/produtosMercado/{id}")
    fun getCurrentRate(@Path(value = "id", encoded = true)from:String) : Call<mercados>
}