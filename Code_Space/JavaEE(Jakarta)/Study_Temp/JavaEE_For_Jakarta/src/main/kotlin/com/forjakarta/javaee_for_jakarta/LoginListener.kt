package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.annotation.WebListener
import jakarta.servlet.http.HttpSessionEvent
import jakarta.servlet.http.HttpSessionListener

@WebListener
class LoginListener:HttpSessionListener {

    private var sessionCount = 0

    override fun sessionCreated(se: HttpSessionEvent?) {
        sessionCount++

        print("\nOne Session Created!\nOnline Players:$sessionCount\n")

    }

    override fun sessionDestroyed(se: HttpSessionEvent?) {

        print("\nOne Player OutLine!\n")

        if(sessionCount<=0)
            sessionCount = 0
        else
            sessionCount--

        print("Online Players:$sessionCount\n")

    }

}