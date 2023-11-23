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
        val sql = "insert into st.user(id,name,age,address) values(3,'王五',23,'小康村')"
        try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/st", "root", "123").use { conn ->
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
