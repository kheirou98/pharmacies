package com.example.pharmacies2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import android.widget.Toast.LENGTH_SHORT
import kotlinx.android.synthetic.main.activity_login_form.*

class Login_form : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_form)
        supportActionBar?.setTitle("Connexion")
        inscription.setOnClickListener {
            val intent_register = Intent(this, Register_form::class.java)
            startActivity(intent_register)
        }
        forgetmdp.setOnClickListener {
            val manager = supportFragmentManager.beginTransaction()
            val popupclass = popup()
            popupclass.show(manager, null)
        }
        cnx.setOnClickListener {
            if (numero.text.toString()==""){
                Toast.makeText(this,"Veuillez remplir les champs de la connexion svp!", LENGTH_SHORT).show()
            }
            else {
                if(mdp.text.toString()=="") {
                    Toast.makeText(this,"Veuillez remplir le champs du mot de passe svp!",LENGTH_SHORT).show()
                }
                else{
                    val builder =  AlertDialog.Builder(this)
                    val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
                    val messages = dialogView.findViewById <TextView>(R.id.message)
                    messages.text =  " Connexion en cours ... "
                    builder.setView(dialogView)
                    builder.setCancelable(false)
                    val dialog = builder.create()
                    dialog.show()
                    var  intent_navigation=Intent(this@Login_form, navigation::class.java).apply { putExtra("bool","vrai") }
                    startActivity(intent_navigation)
                }
            }
        }

    }

}

