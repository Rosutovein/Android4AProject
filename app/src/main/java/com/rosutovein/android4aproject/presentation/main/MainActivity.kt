package com.rosutovein.android4aproject.presentation.main

import android.content.Intent
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
                    val intent = Intent(this, PokedexActivity::class.java)
                    startActivity(intent)
                }
                    LoginError -> {
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Error")
                            .setMessage("Account Unknown")
                            .setPositiveButton("Ok") {
                                dialog, which -> dialog.dismiss()
                            }
                            .show()
                    }
            }
        })

        login_button.setOnClickListener{
            if( (login_edit.text.toString().trim()!="" && password_edit.text.toString()!="") ){
                mainViewModel.onClickedLogin(login_edit.text.toString().trim(), password_edit.text.toString())
                login_edit.setText("")
                password_edit.setText("")
            }else{
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Some fields are empty...")
                    .setPositiveButton("Ok") {
                            dialog, which -> dialog.dismiss()
                    }
            }
        }

        create_account_button.setOnClickListener{
            if(login_edit.text.toString().trim()!="" && password_edit.text.toString()!=""){
                mainViewModel.onClickedCreateAccount(login_edit.text.toString().trim(), password_edit.text.toString())
                MaterialAlertDialogBuilder(this)
                    .setTitle("Success")
                    .setMessage("User created")
                    .setPositiveButton("Ok") {
                            dialog, which -> dialog.dismiss()
                    }
                    .show()
                login_edit.setText("")
                password_edit.setText("")
            }
            else{
                MaterialAlertDialogBuilder(this)
                    .setTitle("Error")
                    .setMessage("Some fields are empty...")
                    .setPositiveButton("Ok") {
                            dialog, which -> dialog.dismiss()
                    }
            }
        }
    }
}