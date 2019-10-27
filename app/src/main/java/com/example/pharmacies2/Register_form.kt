package com.example.pharmacies2
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AlertDialog
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_register_form.*
import kotlinx.android.synthetic.main.activity_register_form.numero
import com.twilio.Twilio
import com.twilio.type.PhoneNumber
import com.twilio.rest.api.v2010.account.Message


class Register_form : AppCompatActivity() {
    var genre:String? = null
    val ACCOUNT_SID = "AC5ef872f6da5a21de157d80997a64bd33"
    val AUTH_TOKEN = "your_auth_token"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_form)
        supportActionBar?.setTitle("Inscription")
        var profils: ArrayList<profil> = ArrayList()
        button.setOnClickListener {
            if (nss.text.toString() == "") {
                Toast.makeText(
                    this,
                    "Veuillez remplir le champs du numéro de la sécurité sociale svp!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                if (nom.text.toString() == "") {
                    Toast.makeText(this, "Veuillez remplir le champs du nom svp!", Toast.LENGTH_SHORT).show()
                } else {
                    if (prenom.text.toString() == "") {
                        Toast.makeText(this, "Veuillez remplir le champs du prénom svp!", Toast.LENGTH_SHORT).show()
                    } else {
                        if (adresse.text.toString() == "") {
                            Toast.makeText(this, "Veuillez remplir le champs de l'adresse svp!", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            if (numero.text.toString() == "") {
                                Toast.makeText(this, "Veuillez remplir le champs du numéro svp!", Toast.LENGTH_SHORT)
                                    .show()
                            }
                            else {
                                if (!homme.isChecked && !femme.isChecked){
                                    Toast.makeText(this, "Veuillez choisir le sexe svp!", Toast.LENGTH_SHORT)
                                        .show()
                                }
                                else {
                                    if (homme.isChecked) {
                                        genre = "homme"
                                        profils.add(
                                            profil(
                                                nom.text.toString(),
                                                prenom.text.toString(),
                                                nss.text.toString().toLong(),
                                                adresse.text.toString(),
                                                numero.text.toString().toLong(),
                                                genre.toString()
                                            )
                                        )
                                    } else {
                                        genre = "femme"
                                        profils.add(
                                            profil(
                                                nom.text.toString(),
                                                prenom.text.toString(),
                                                nss.text.toString().toLong(),
                                                adresse.text.toString(),
                                                numero.text.toString().toLong(),
                                                genre.toString()
                                            )
                                        )
                                    }
                                    //val builder = AlertDialog.Builder(this)
                                    //builder.setCancelable(false) // if you want user to wait for some process to finish,
                                    val builder =  AlertDialog.Builder(this)
                                    val dialogView = layoutInflater.inflate(R.layout.progress_dialog,null)
                                    val messages = dialogView.findViewById <TextView>(R.id.message)
                                    messages.text =  " Inscription en cours ... "
                                    builder.setView(dialogView)
                                    builder.setCancelable(false)
                                    val dialog = builder.create()
                                    dialog.show()
                                    Handler () .postDelayed ({dialog.dismiss ()}, 5000 )
                                    var  intent_navigation=Intent(this@Register_form, navigation::class.java).apply { putExtra("bool","vrai") }
                                    startActivity(intent_navigation)
                                    var number1=numm.text.toString()
                                    var number2=numero.text.toString()
                                    var number= "$number1$number2"
                                   /* Twilio.init(ACCOUNT_SID, AUTH_TOKEN)
                                    var message = Message.creator(
                                        PhoneNumber(number), PhoneNumber("+14158141829"),
                                        "Votre mot de passe est : "
                                    )
                                    message.create()*/
                                }

                            }
                        }
                    }
                }
            }
        }

    }
}
