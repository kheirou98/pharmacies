package com.example.pharmacies2

data class profil
    (var nom:String,var prenom:String,var nss: Long,var adresse: String,var numero :Long,var sexe:String){
    fun getnom() : String = nom
    fun getprenom() : String = prenom
    fun getnss() : Long = nss
    fun getadresse() : String = adresse
    fun getnumero() : Long = numero
    fun getsexe():String=sexe

}