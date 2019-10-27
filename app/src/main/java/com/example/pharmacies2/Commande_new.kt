package com.example.pharmacies2

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.view.View
import kotlinx.android.synthetic.main.activity_commande_new.*
import java.util.zip.Inflater

class Commande_new : AppCompatActivity() {
    internal val REQUEST_CODE_GALLERY = 999
    internal val REQUEST_IMAGE_CAPTURE = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_commande_new)
        supportActionBar?.setTitle("Nouvelle commande")
        supportActionBar?.setCustomView(R.layout.activity_commande_new)
        btnChoose.setOnClickListener {    ActivityCompat.requestPermissions(
            this@Commande_new,
            arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
            REQUEST_CODE_GALLERY
        )
            val cmd_Intent = Intent(this@Commande_new, navigation::class.java).apply{ putExtra("commande","vrai") }
            startActivity(cmd_Intent) }
        bucpat.setOnClickListener {
            val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            if (takePictureIntent.resolveActivity(packageManager) != null) {
                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
            }
            val cmd_Intent = Intent(this@Commande_new, navigation::class.java).apply{ putExtra("commande","vrai") }
            startActivity(cmd_Intent)
        }
        }
    }