package com.svh.studentventures_hub.dao_party.dao_model.base

import java.sql.Connection
import java.sql.PreparedStatement
import java.sql.ResultSet
import javax.naming.Context
import javax.naming.InitialContext
import javax.sql.DataSource

abstract class BaseDao {

    fun getConnection(): Connection? {
        var connection: Connection? = null

        try{
            val context:Context = InitialContext()
            val dataSource:DataSource = context.lookup("java:comp/env/jdbc/StudentVenture_Hub") as DataSource

            connection = dataSource.connection
        }catch (e:Exception){
            e.printStackTrace()
        }

        return  connection

    }

    protected fun closeResources(resultSet: ResultSet?, preparedStatement: PreparedStatement?, connection: Connection?) {

        try {
            resultSet?.close()
            preparedStatement?.close()
            connection?.close()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }



}