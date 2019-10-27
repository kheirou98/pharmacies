package com.example.pharmacies2
data class pharmacie_detail
    (var nom:String,var adresse:String,var horaires: String,var caisses: String,var facebook :String,var gps: String){
    fun getnom() : String = nom
    fun getadresse() : String = adresse
    fun gethoraires() : String = horaires
    fun getcaisses() : String = caisses
    fun getfacebook() : String = facebook
    fun getgps() : String = gps


}