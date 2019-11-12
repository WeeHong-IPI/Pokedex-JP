package com.weehong.pokedex

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import com.weehong.pokedex.model.Pokemon
import com.weehong.pokedex.request.PokemonApi
import com.weehong.pokedex.request.PokemonService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private val pokemonListView: MutableList<Pokemon> = mutableListOf()
    private lateinit var pokemonAdapter: PokemonAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pokemonAdapter = PokemonAdapter(pokemonListView)

        pokemon_list_view.layoutManager = LinearLayoutManager(this)
        pokemon_list_view.addItemDecoration(DividerItemDecoration(this, OrientationHelper.VERTICAL))
        pokemon_list_view.adapter = pokemonAdapter

        loadPokemons()
    }

    private fun loadPokemons() {
        val pokemonList = PokemonService.buildService(PokemonApi::class.java)

        val requestCall: Call<List<Pokemon>> = pokemonList.getPokemonList("1572848655474")

        requestCall.enqueue(object : Callback<List<Pokemon>> {
            override fun onFailure(call: Call<List<Pokemon>>, t: Throwable) {
                Log.d("Pokemon", t.toString())
            }

            override fun onResponse(call: Call<List<Pokemon>>, response: Response<List<Pokemon>>) {
                if (response.isSuccessful) {
                    val responseList: List<Pokemon> = response.body()!!
                    for (pokemon in responseList) {
                        pokemonListView.addAll(pokemon)
                    }
                    pokemonAdapter.notifyDataSetChanged()
                }
            }
        })
    }
}
