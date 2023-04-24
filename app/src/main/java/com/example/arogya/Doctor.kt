package com.example.arogya.model

data class Doctor(
    var email : String,
    var experience:String,
    var field:String,
    var name : String,
    var password : String,
    var qualification : String,
    var userName : String
    ){
    constructor() : this("", "", "","","","","")
}
