package com.weehong.pokedex.request

import com.weehong.pokedex.model.Pokemon
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("zukan/scripts/data/top_zukan.json?_=1572848655474")
    fun getPokemonList(@Query("_") key: String): Call<List<Pokemon>>
}