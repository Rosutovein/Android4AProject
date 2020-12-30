package com.rosutovein.android4aproject.presentation.retrofit

import com.rosutovein.android4aproject.data.remote.Pokedex
import io.reactivex.Observable
import retrofit2.http.GET

interface IPokemonList {
    @get: GET("pokedex.json")
    val listPokemon:Observable<Pokedex>
}