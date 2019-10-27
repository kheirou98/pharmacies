package com.example.pharmacies2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_profil_detail.*
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.widget.ArrayAdapter




class Profil_detail : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil_detail)
        supportActionBar?.setTitle("Mon profil")
        supportActionBar?.setCustomView(R.layout.activity_profil_detail)
        val sexe = arrayOf("Homme","Femme")
        val MydataAdapter = ArrayAdapter<String>(this@Profil_detail, android.R.layout.simple_spinner_dropdown_item, sexe)
        ed5.setOnClickListener(View.OnClickListener {
            ed5.setInputType(InputType.TYPE_NULL); //To hide the softkeyboard
            AlertDialog.Builder(this@Profil_detail)
                .setTitle("Sélectionner le sexe:")
                .setAdapter(MydataAdapter, DialogInterface.OnClickListener { dialog, which ->
                    ed5.setText(sexe[which].toString())
                    dialog.dismiss()
                }).create().show()
        })
        modify.setOnClickListener {
        ed1.isEnabled=true
        ed2.isEnabled=true
        ed3.isEnabled=true
        ed4.isEnabled=true
            ed5.isEnabled=true
            ed5.isFocusable=false
        ed5.isClickable=true
        modify.visibility= View.INVISIBLE
        ok.visibility=View.VISIBLE

        }
        ok.setOnClickListener {
            ed1.isEnabled=false
            ed2.isEnabled=false
            ed3.isEnabled=false
            ed4.isEnabled=false
            ed5.isEnabled=false
            ok.visibility=View.INVISIBLE
            modify.visibility= View.VISIBLE
        }
    }
}
