package com.svh.studentventures_hub.dao_party.object_model.info

class Student(
    val studentCode:String,
    val classCode:String,
    var studentName:String,
    private var studentSex:String,
    var telephone:String,
    var password:String,
    var studentState:String
)