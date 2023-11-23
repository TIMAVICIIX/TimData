package com.forjakarta.javaee_for_jakarta

class Student(inID: String, inName: String, inBirth: String) {

    private var id: String
    private var name: String
    private var birthDay: String

    init {

        id = inID
        name = inName
        birthDay = inBirth

    }

    fun displayData(){

        print("ID:$id\nName:$name\nBirth_Day:$birthDay\n")

    }

}