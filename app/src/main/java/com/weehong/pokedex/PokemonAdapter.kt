package com.weehong.pokedex

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.weehong.pokedex.model.Pokemon
import kotlinx.android.synthetic.main.layout_pokemon_list.view.*

class PokemonAdapter(private val pokemonList: MutableList<Pokemon>) : RecyclerView.Adapter<PokemonHolder>() {

    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonHolder {
        context = parent.context
        return PokemonHolder(LayoutInflater.from(context).inflate(R.layout.layout_pokemon_list, parent, false))
    }

    override fun onBindViewHolder(holder: PokemonHolder, position: Int) {
        val pokemonData = pokemonList[position]
        val pokemonName = holder.itemView.name
        pokemonName.text = pokemonData.pokemonName
    }

    override fun getItemCount() = pokemonList.size

}