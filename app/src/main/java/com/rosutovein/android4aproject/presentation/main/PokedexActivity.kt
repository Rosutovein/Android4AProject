package com.rosutovein.android4aproject.presentation.main

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.rosutovein.android4aproject.R
import com.rosutovein.android4aproject.presentation.PokemonDetail
import com.rosutovein.android4aproject.presentation.common.Common
import kotlinx.android.synthetic.main.activity_pokedex.*

class PokedexActivity: AppCompatActivity() {

    //Broadcast Handle
    private val showDetail = object:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent!!.action!!.toString() == Common.KEY_NUM_EVOLUTION){
                supportActionBar!!.setDisplayHomeAsUpEnabled(true)
                supportActionBar!!.setDisplayShowHomeEnabled(true)

                //Replace Fragment
                val detailFragment = PokemonDetail.getInstance()
                val position = intent.getIntExtra("position", -1)
                val bundle = Bundle()
                bundle.putInt("position", position)
                detailFragment.arguments = bundle

                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                //Set Pokemon name for toolbar
                val pokemon = Common.pokemonList[position]
                toolbar.title = pokemon.name
            }
        }

    }

    private val showEvolution = object:BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            /*if(intent!!.action!!.toString() == Common.KEY_NUM_EVOLUTION){

                //Replace Fragment
                val detailFragment = PokemonDetail.getInstance()
                val bundle = Bundle()
                val num = intent.getStringExtra("num")
                bundle.putString("num", num)
                detailFragment.arguments = bundle

                val fragmentTransaction = supportFragmentManager.beginTransaction()
                fragmentTransaction.remove(detailFragment)
                fragmentTransaction.replace(R.id.list_pokemon_fragment, detailFragment)
                fragmentTransaction.addToBackStack("detail")
                fragmentTransaction.commit()

                //Set Pokemon name for toolbar
                val pokemon = Common.findPokemonByNum(num)
                toolbar.title = pokemon!!.name
            }*/
        }

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)

        toolbar.setTitle("Pokemon G1")
        setSupportActionBar(toolbar)

        //Register broadcast
        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showDetail, IntentFilter(Common.KEY_NUM_EVOLUTION))

        LocalBroadcastManager.getInstance(this)
            .registerReceiver(showEvolution, IntentFilter(Common.KEY_NUM_EVOLUTION))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                toolbar.title = "ALL POKEMON 1G"
                //Clear fragment with name "detail"
                supportFragmentManager.popBackStack("detail", FragmentManager.POP_BACK_STACK_INCLUSIVE)

                supportActionBar!!.setDisplayShowHomeEnabled(false)
                supportActionBar!!.setDisplayHomeAsUpEnabled(false)
            }
        }
        return true
    }
}