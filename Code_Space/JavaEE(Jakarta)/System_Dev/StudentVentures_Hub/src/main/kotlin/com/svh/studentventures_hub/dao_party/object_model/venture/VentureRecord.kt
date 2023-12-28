package com.svh.studentventures_hub.dao_party.object_model.venture

class VentureRecord(
    val studentCode:String,
    val ventureCode:String,
    val ventureName:String,
    val studentName:String,
    var destination:String,
    var ventureDes:String
){
    constructor() : this("", "", "", "", "", "")
}