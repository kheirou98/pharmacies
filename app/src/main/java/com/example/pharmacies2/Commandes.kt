package com.example.pharmacies2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_commandes.*

class Commandes : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commandes)
        supportActionBar?.setTitle("Mes commandes")
        supportActionBar?.setCustomView(R.layout.activity_commandes)
        var commandes: ArrayList<String> = ArrayList()
        for (i in 1..10){
            commandes.add("Commande $i" )
        }
        recyclerview.layoutManager= LinearLayoutManager(this)
        recyclerview.adapter=commandeadapter(commandes,this)
    }
}
