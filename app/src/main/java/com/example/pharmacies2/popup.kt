package com.example.pharmacies2

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.popup.*

class popup : DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceCreate: Bundle?): View? {
        val view= inflater.inflate(R.layout.popup, container, false)
        return view
        //annuler.setOnClickListener { popup().dismiss() }

    }

}
