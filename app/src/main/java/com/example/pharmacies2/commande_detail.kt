package com.example.pharmacies2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class commande_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commande_detail)
        supportActionBar?.setTitle("Détails de la commande")
        supportActionBar?.setCustomView(R.layout.activity_commande_detail)
    }
}
