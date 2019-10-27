package com.example.pharmacies2

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contact.*

class Contact: DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceCreate: Bundle?): View? {
        val view= inflater.inflate(R.layout.activity_contact, container, false)
        val phone=view.findViewById<Button>(R.id.phone)
        val email=view.findViewById<Button>(R.id.email)
        val fcbk=view.findViewById<Button>(R.id.fcbk)
        phone!!.setOnClickListener {
            Toast.makeText(context, "Appel téléphonique ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(browserintent)
            this.dismiss()
        }
        fcbk!!.setOnClickListener { Toast.makeText(context, "Ouverture de notre page Facebook ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
            startActivity(browserintent)
            this.dismiss()}
        email!!.setOnClickListener {       val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.gmail.com"))
            startActivity(browserintent)
            this.dismiss()}
        return view
    }
}