package com.svh.studentventures_hub.dao_party.dao_model.base

import kotlin.random.Random

interface UserStructMethod<T> {

    fun authCookie(authID:String):T?

    fun setCookie(setTarget:T):String

    fun generateCookieCode():String{


        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9') + listOf('!', '@', '#', '$', '%', '^', '&', '*')
        val random = Random.Default
        return (1..18)
            .map { random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")

    }

    fun generatePassword():String{

        val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
        val random = Random.Default
        return (1..8)
            .map { random.nextInt(0, charPool.size) }
            .map(charPool::get)
            .joinToString("")
    }

    fun getUserCodeList():MutableList<String>

    fun reSetPassword(userFilter:String,newPassword:String?):String

}