package com.example.pharmacies2

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.pharmacie_detail.*

class pharmacies_detail : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pharmacie_detail)
        supportActionBar?.setTitle("Pharmacie Souf")
        supportActionBar?.setCustomView(R.layout.pharmacie_detail)
        var bundle = intent.extras
        if (bundle!=null){
            var connexion=bundle.getString("commande from navigation")
            if (connexion?.toString().equals("true"))
            {commande.visibility=View.VISIBLE
            }
            else{  if (connexion?.toString().equals("false"))
            {commande.visibility=View.INVISIBLE}
            }
        }
        var pharmacies: ArrayList<pharmacie_detail> = ArrayList()
        pharmacies.add(pharmacie_detail("souf","GDC","07h-23h","cnas-casnos-militaire","souf pharmacie","gué de constantine"))
        nom.setText(pharmacies.get(0).getnom())
        adresse.setText(pharmacies.get(0).getadresse())
        horaires.setText(pharmacies.get(0).gethoraires())
        caisses.setText(pharmacies.get(0).getcaisses())
        facebook.setText(pharmacies.get(0).getfacebook())
        gps.setText(pharmacies.get(0).getgps())
        commande.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setMessage("Etes vous sur de lancer votre commande?")
                .setIcon(R.drawable.ic_check_black_24dp).setTitle("Confirmer la commande").setPositiveButton(
                    "Oui"
                ) { _, _->this.finish()
                    Toast.makeText(this@pharmacies_detail, "Merci d'attendre jusqu'au traitement de la commande", Toast.LENGTH_LONG).show()
                    val myIntent = Intent(this@pharmacies_detail, Commandes::class.java)
                    startActivity(myIntent)}.setNegativeButton(
                    "Non"
                ) {_,_-> }.show()
        }
        gps.setOnClickListener {  Toast.makeText(this, "Ouverture du Google Map ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/esi.dz/devit/accueil"))
            startActivity(browserintent) }
        facebook.setOnClickListener {
            Toast.makeText(this, "Ouverture de la page facebook ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/DEVit-1233852490057173/"))
            startActivity(browserintent)
        }
    }
}