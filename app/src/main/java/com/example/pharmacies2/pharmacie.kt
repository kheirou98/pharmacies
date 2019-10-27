package com.example.pharmacies2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.Toast.LENGTH_LONG

class pharmacie : Fragment() {
    private var spinner: Spinner?=null
    private var spinner2: Spinner?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Affichage des pharmacies"
        var wilayas= arrayOf("Wilaya","01-Adrar","02-Chlef","12-Tebessa","16-Alger")
        var pharmacies= arrayOf("Ville","01-Kouba","02-GDC","12-Hydra","16-El Biar")
        val v= inflater.inflate(R.layout.fragment_pharmacie, container, false)
       val consulter = v.findViewById<Button>(R.id.consult)
        val valider = v.findViewById<Button>(R.id.validate)
        if(arguments!=null){
            var commande = arguments?.getString("commande from navigation")
        if (commande!!.toString().equals("true")) {
            showOrInvisible(true,consulter,valider) }
        }
        spinner = v.findViewById<Spinner>(R.id.spinner1)
        spinner2 = v.findViewById<Spinner>(R.id.spinner2)
        spinner!!.adapter= ArrayAdapter(context!!,R.layout.spinner_item,wilayas)
        spinner!!.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
              if (position==0){}
                else {Toast.makeText(context,wilayas[position],LENGTH_LONG).show()}
            }
        }
        spinner2!!.adapter= ArrayAdapter(context!!,R.layout.spinner_item,pharmacies)
        spinner2!!.onItemSelectedListener=object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if (position==0){}
                else {Toast.makeText(context,pharmacies[position],LENGTH_LONG).show()}
            }
        }
        consulter!!.setOnClickListener {
            val intent= Intent(context, PharmaciesList::class.java)
            intent.putExtra("commande from navigation", "false")
            startActivity(intent)
        }
        valider!!.setOnClickListener {
            val intent= Intent(context, PharmaciesList::class.java)
            intent.putExtra("commande from navigation", "true")
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return v
    }
    //show button and hide another
    fun showOrInvisible(show: Boolean, b1:Button, b2:Button) {
        if (show) {
            b1.visibility=View.INVISIBLE
            b2.visibility=View.VISIBLE
        } else {
            b1.visibility=View.VISIBLE
            b2.visibility=View.INVISIBLE
        }
    }

}