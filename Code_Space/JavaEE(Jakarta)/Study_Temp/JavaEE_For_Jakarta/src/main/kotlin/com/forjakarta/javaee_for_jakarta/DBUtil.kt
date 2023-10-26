package com.forjakarta.javaee_for_jakarta

import java.sql.DriverManager
import java.sql.SQLException

object DBUtil {
    init {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    @Throws(SQLException::class)
    fun createBD(): Boolean {
        val sql = "create database NewData"
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "123").use { conn ->
                conn.createStatement().use { statement ->
                    statement.execute(sql)
                    return true
                }
            }
        } catch (e: SQLException) {
            e.printStackTrace()
        }
        return false
    }
}
