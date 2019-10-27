package com.example.pharmacies2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_splash.*

class splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        imageFade.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade))
        pg.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.fade))
        Handler().postDelayed({
            //start main activity
            startActivity(Intent(this@splash, navigation::class.java))
            //finish this activity
            finish()
        }, 4000)
    }
}
