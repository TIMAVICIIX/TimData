package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoTools.Companion.getEntityList
import com.svh.studentventures_hub.dao_party.object_model.venture.VentureRecord

class VentureRecordDAO : BaseDao(), DaoStructMethod<VentureRecord> {


    override val tableName: String = "ventureclass_records"

    override fun save(targetObject: VentureRecord): Boolean {
        val sqlContext = "INSERT INTO $tableName(ventureCode,studentCode,ventureName,studentName,destination,ventureDes) VALUES(?,?,?,?,?,?);"

        getConnection()?.use { connection ->
            connection.prepareStatement(sqlContext).use { preparedStatement ->
                preparedStatement.setString(1, targetObject.ventureCode)
                preparedStatement.setString(2, targetObject.studentCode)
                preparedStatement.setString(3,targetObject.ventureName)
                preparedStatement.setString(4,targetObject.studentName)
                preparedStatement.setString(5, targetObject.destination)
                preparedStatement.setString(6, targetObject.ventureDes)
                preparedStatement.executeUpdate()

                return true
            }
        }

        return false

    }

    override fun update(targetObject: VentureRecord): Boolean {
        val sqlContext = "UPDATE $tableName SET destination=?,ventureDes=? WHERE (ventureCode=? AND studentCode=?);"

        getConnection()?.use { connection ->
            connection.prepareStatement(sqlContext).use {

                it.setString(1, targetObject.destination)
                it.setString(2, targetObject.ventureDes)
                it.setString(3, targetObject.ventureCode)
                it.setString(4, targetObject.studentCode)
                it.executeUpdate()

                return true
            }

        }

        return false
    }

    override fun delete(deleteString: String): Boolean {
        val sqlContext = "DELETE FROM $tableName WHERE (studentCode=? AND VentureCode=?);"

        getConnection()?.use { connection ->
            connection.prepareStatement(sqlContext).use {

                val deleteCodes = deleteString.split("&&")

                it.setString(1, deleteCodes[0])
                it.setString(2, deleteCodes[1])

                it.executeUpdate()

                return true
            }
        }

        return false
    }

    override fun completeQuery(): MutableList<VentureRecord> {
        TODO("Not yet implemented")
    }

    override fun filterQuery(filterString: String): MutableList<VentureRecord> {
        TODO("Not yet implemented")
    }

    /**
     * @param identityToken 假期号
     * @param filterString 学生学籍号
     */

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<VentureRecord> {
        val sqlContext = "SELECT * FROM $tableName WHERE(ventureCode=? AND studentCode=?);"

        var ventureRecordList: MutableList<VentureRecord> = mutableListOf()

        getConnection()?.use { connection ->
            connection.prepareStatement(sqlContext).use {

                it.setString(1, identityToken)
                it.setString(2, filterString)

                it.executeQuery()?.use { resultSet ->
                    ventureRecordList = resultSet.getEntityList<VentureRecord>()
                }
            }

        }

        return ventureRecordList
    }

    /**
     * @param filterString ”${假期号} ${学生号}“
     */
    override fun exactQuery(filterString: String): VentureRecord? {
        val sqlContext = "SELECT * FROM $tableName WHERE (ventureCode=? AND studentCode=?);"

        val (ventureCode, studentCode) = filterString.split(" ")
        var ventureRecord:VentureRecord? = null

        getConnection()?.use { conn->
            conn.prepareStatement(sqlContext)?.use {

                it.setString(1,ventureCode)
                it.setString(2,studentCode)

                it.executeQuery()?.use { resultSet ->

                    ventureRecord = resultSet.getEntityList<VentureRecord>().firstOrNull()

                }

            }
        }

        return ventureRecord

    }

    override fun filterCount(fileType: String, filterString: String): Int {
        TODO("Not yet implemented")
    }

    fun getStuRecordString(stuCode: String): String {
        val sqlContext = "SELECT ventureCode FROM $tableName WHERE studentCode=?;"

        val recordStringBuilder = StringBuilder()

        getConnection()?.use { connection ->
            connection.prepareStatement(sqlContext).use {
                it.setString(1, stuCode)
                it.executeQuery()?.use { resultSet ->

                    while (resultSet.next()) {
                        recordStringBuilder.append(resultSet.getString("ventureCode"))
                    }
                }

            }
        }

        return recordStringBuilder.toString()

    }
}