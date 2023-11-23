package com.finall_project.model.class_about

import com.finall_project.enumtool.Sex

class Student(
    val name: String,
    val id: String,
    val sex: Sex,
    var major: String,
    var contactInformation: ArrayList<String>,
    var belongClass: String
)