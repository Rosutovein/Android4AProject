package com.rosutovein.android4aproject.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.rosutovein.android4aproject.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject;

class MainActivity : AppCompatActivity() {
    val mainViewModel : MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Ecoute sur la liveData
        mainViewModel.loginLiveData.observe(this, Observer {
            when(it){
                is LoginSuccess -> {
                    //TODO NAVIGATE
                }
                    LoginError -> {
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Erreur")
                            .setMessage("Compte inconnu")
                            .setPositiveButton("Ok") {
                                dialog, which -> dialog.dismiss()
                            }
                            .show()
                    }
            }
        })
        login_button.setOnClickListener{
            mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
        }

    }
}