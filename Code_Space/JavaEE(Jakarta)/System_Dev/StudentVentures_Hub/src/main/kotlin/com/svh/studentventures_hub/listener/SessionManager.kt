package com.svh.studentventures_hub.listener

import jakarta.servlet.annotation.WebListener
import jakarta.servlet.http.HttpSession
import jakarta.servlet.http.HttpSessionEvent
import jakarta.servlet.http.HttpSessionListener

@WebListener
class SessionManager : HttpSessionListener {

    companion object {

        private val userSessionMap = mutableMapOf<String, HttpSession>()


        fun associateUserWithSession(userId: String, session: HttpSession) {
//            println("注册会话,会话ID:${session.id}")
            userSessionMap[userId] = session
        }


        private fun getSessionByUserId(userId: String): HttpSession? {
//            if (userSessionMap[userId] != null) {
//                println("获得待销毁会话,会话ID:${userSessionMap[userId]?.id}")
//            } else {
//                println("未待销毁会话")
//            }
            return userSessionMap[userId]
        }

        fun getSessionID(userID: String): String {
            return if (userSessionMap[userID] != null) {
                userSessionMap[userID]?.id.toString()
            } else {
                " "
            }
        }

        fun destroy(userID: String) {
            val session = getSessionByUserId(userID)
            session?.let {
                it.invalidate()
                userSessionMap.remove(userID)
            }
//            println("REPORT:")
//            userSessionMap.forEach { (key, value) ->
//                println("USER_ID: $key, SESSION_ID: ${value.id}")
//            }
//            println()

        }

    }

    override fun sessionCreated(se: HttpSessionEvent?) {
        super.sessionCreated(se)
    }

    override fun sessionDestroyed(se: HttpSessionEvent) {
//        println("清理相同会话账户号!")
        val sessionId = se.session.id

        val sessionMapIterator = userSessionMap.entries.iterator()
        while (sessionMapIterator.hasNext()){
            val keyValue = sessionMapIterator.next()
            if (keyValue.value.id == sessionId){
                sessionMapIterator.remove()
            }
        }
    }


}
