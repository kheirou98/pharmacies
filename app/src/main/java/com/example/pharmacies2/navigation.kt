package com.example.pharmacies2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import kotlinx.android.synthetic.main.activity_navigation.*
import kotlinx.android.synthetic.main.app_bar_navigation.*
import kotlinx.android.synthetic.main.navigationbar.*

class navigation : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)
        setSupportActionBar(toolbar)
        supportActionBar?.setTitle("Accueil")
    //    supportActionBar?.setCustomView(R.layout.activity_navigation)
         val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.Home -> {
                    replaceFragment(home())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    replaceFragment(pharmacie())
                    return@OnNavigationItemSelectedListener true
                }
                R.id.aide -> {
                    replaceFragment(aide())
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        replaceFragment(home())
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
        var bundle = intent.extras
        if (bundle!=null){
       var connexion=bundle.getString("bool")
       if (connexion?.toString().equals("vrai"))
       {hideItem()
       }
            var bundle_cmd = intent.extras
            if (bundle_cmd!=null) {
                var commande = bundle_cmd.getString("commande")
                if (commande?.toString().equals("vrai")) {
                    val bundle_frag = Bundle().apply {
                        putString("commande from navigation", "true")
                    }
                    val frag_pharma=pharmacie()
                    frag_pharma.arguments=bundle_frag
                    replaceFragment(frag_pharma)
                }
                hideItem()
            }
        }


    }
    //Fonction pour passer d'un fragment à un autre
    private fun replaceFragment(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.connexion -> {
                val myIntent = Intent(this@navigation, Login_form::class.java)
                startActivity(myIntent)
            }
            R.id.cmd -> {
                val myIntent = Intent(this@navigation, Commande_new::class.java)
                startActivity(myIntent)
            }
            R.id.profil -> {
                val myIntent = Intent(this@navigation, Profil_detail::class.java)
                startActivity(myIntent)
            }
            R.id.cmds -> {
                val myIntent = Intent(this@navigation, Commandes::class.java)
                startActivity(myIntent)
            }
            R.id.deconnect -> {
                replaceFragment(home())
                donotshowItem()
            }
            R.id.contact-> {
                val manager = supportFragmentManager.beginTransaction()
                val popupclass = Contact()
                popupclass.show(manager, null)
            }
            R.id.apropos-> {
                val myIntent = Intent(this@navigation, Apropos::class.java)
                startActivity(myIntent)
            }
            R.id.exit-> {
                val builder = AlertDialog.Builder(this)
                builder.setMessage("Etes vous sur de quitter l'application?")
                    .setIcon(R.drawable.ic_close_black_24dp).setTitle("Quitter l'application").setPositiveButton(
                        "Oui"
                    ) { _, _ ->this.finish()
                        Toast.makeText(this@navigation, "Merci d'avoir utilisé notre Application",LENGTH_LONG).show()}.setNegativeButton(
                        "Non"
                    ) { _, _-> }.show()

            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun hideItem() {
        val nav_Menu = nav_view.getMenu()
        nav_Menu.findItem(R.id.cmd).setVisible(true)
        nav_Menu.findItem(R.id.cmds).setVisible(true)
        nav_Menu.findItem(R.id.profil).setVisible(true)
        nav_Menu.findItem(R.id.deconnect).setVisible(true)
    }
    fun donotshowItem() {
        val nav_Menu = nav_view.getMenu()
        nav_Menu.findItem(R.id.cmd).setVisible(false)
        nav_Menu.findItem(R.id.cmds).setVisible(false)
        nav_Menu.findItem(R.id.profil).setVisible(false)
        nav_Menu.findItem(R.id.deconnect).setVisible(false)
    }
}
