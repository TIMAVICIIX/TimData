package com.svh.studentventures_hub.dao_party.dao_model.base

import java.lang.reflect.Field
import java.sql.ResultSet

class DaoTools {

    companion object {


        inline fun <reified T : Any> ResultSet.getEntityList(): MutableList<T> {
            val resultList = mutableListOf<T>()
            while (this.next()) {
                val entity = resultSetToEntity<T>(this)
                resultList.add(entity)
            }
            return resultList
        }

        inline fun <reified T : Any> resultSetToEntity(resultSet: ResultSet): T {

            val entity = T::class.java.getDeclaredConstructor().newInstance()
            val metaData = resultSet.metaData
            for (i in 1..metaData.columnCount) {
                val columnName = metaData.getColumnName(i)
                val columnValue = resultSet.getObject(i)

                val field: Field? = try {
                    T::class.java.getDeclaredField(columnName)
                } catch (e: NoSuchFieldException) {
                    null
                }

                field?.let {
                    it.isAccessible = true
                    it.set(entity, columnValue)
                }
            }
            return entity
        }

        fun Any?.toStringOrBlank(): String {
            return this?.toString() ?: " "
        }

    }

}