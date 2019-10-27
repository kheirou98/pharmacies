package com.example.pharmacies2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_commandes.*
import kotlinx.android.synthetic.main.activity_commandes.recyclerview
import kotlinx.android.synthetic.main.activity_pharmacies_list.*

class PharmaciesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pharmacies_list)
        supportActionBar?.setTitle("Les pharmacies")
        supportActionBar?.setCustomView(R.layout.activity_pharmacies_list)
        var pharmacies: ArrayList<String> = ArrayList()
        for (i in 1..10){
            pharmacies.add("Pharmacie $i" )
        }
      var bundle=intent.extras
        if (bundle!=null){
            var connexion=bundle.getString("commande from navigation")
            if (connexion?.toString().equals("true"))
            {
                recyclerview.layoutManager= LinearLayoutManager(this)
                recyclerview.adapter=pharmacieadapter(pharmacies,this)
            }
        else {
                if (connexion?.toString().equals("false"))
                {
                    recyclerview.layoutManager= LinearLayoutManager(this)
                    recyclerview.adapter=pharmacieadapter2(pharmacies,this)
                }
            }}

    }
}
