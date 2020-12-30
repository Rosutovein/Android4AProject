package com.rosutovein.android4aproject.presentation.main

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import com.rosutovein.android4aproject.R
import kotlinx.android.synthetic.main.activity_pokedex.*

class PokedexActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokedex)

        toolbar.setTitle("ITS PIKACHU")
        setSupportActionBar(toolbar)
    }
}