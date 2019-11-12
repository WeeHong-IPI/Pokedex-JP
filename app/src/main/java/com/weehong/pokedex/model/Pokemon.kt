package com.weehong.pokedex.model


import com.google.gson.annotations.SerializedName

data class Pokemon(
    @SerializedName("omosa")
    val omosa: Double,
    @SerializedName("pokemon_name")
    val pokemonName: String,
    @SerializedName("sub_id")
    val subId: String,
    @SerializedName("sub_name")
    val subName: String,
    @SerializedName("takasa")
    val takasa: Double,
    @SerializedName("tokusei")
    val tokusei: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("zukan_no")
    val zukanNo: String
)