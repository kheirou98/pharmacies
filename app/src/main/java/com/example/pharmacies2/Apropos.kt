package com.example.pharmacies2

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_apropos.*
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.navigationbar.*

class Apropos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apropos)
        supportActionBar?.setTitle("A propos")
        supportActionBar?.setCustomView(R.layout.activity_apropos)
        button4.setOnClickListener{
            Toast.makeText(this, "Ouverture du site Web ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(browserintent)
        }
        button.setOnClickListener {
            Toast.makeText(this, "Ouverture de notre page Facebook ...", Toast.LENGTH_LONG).show()
            val browserintent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com"))
            startActivity(browserintent)

        }
    }
}