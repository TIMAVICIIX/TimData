package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.Class
import com.svh.studentventures_hub.dao_party.object_model.info.Student

class ClassDAO : BaseDao(), DaoStructMethod<Class> {

    override val tableName: String = "infoclass_classes"

    override fun save(targetObject: Class): Boolean {
        val sqlContext = "INSERT INTO $tableName(ClassCode,SpecialityCode,ClassStartTime,SpecialityName,ClassName) " +
                "VALUES(?,?,?,?,?);"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.classCode)
                    it.setString(2, targetObject.specialtyCode)
                    it.setString(3, targetObject.classStartTime)
                    it.setString(4, targetObject.specialtyName)
                    it.setString(5, targetObject.className)

                    it.executeUpdate()

                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true

    }

    override fun update(targetObject: Class): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(deleteString: String): Boolean {
        val sqlContext: String = "DELETE FROM $tableName WHERE " +
                "ClassCode=?;"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, deleteString)

                    it.executeUpdate()

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true
    }

    override fun completeQuery(): MutableList<Class> {
        TODO("Not yet implemented")
    }

    override fun filterQuery(filterString: String): MutableList<Class> {
        TODO("Not yet implemented")
    }

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<Class> {
        var sqlContext = "SELECT *FROM $tableName WHERE " +
                "(SpecialityCode LIKE '$identityToken%' AND " +
                "(ClassName LIKE '%$filterString%' OR " +
                "ClassCode LIKE '%$filterString%' OR " +
                "SpecialityName LIKE '%$filterString%' OR " +
                "ClassStartTime LIKE '%$filterString%' ));"

        if (identityToken == "52200") {
            sqlContext = "SELECT *FROM $tableName WHERE " +
                    "SpecialityCode LIKE '%$filterString%' OR " +
                    "ClassName LIKE '%$filterString%' OR " +
                    "ClassCode LIKE '%$filterString%' OR " +
                    "SpecialityName LIKE '%$filterString%' OR " +
                    "ClassStartTime LIKE '%$filterString%';"
        }

        val classList: MutableList<Class> = mutableListOf()

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.executeQuery().use { resultSet ->


                        while (resultSet.next()) {

                            val classCode = resultSet.getString("ClassCode")
                            val className = resultSet.getString("ClassName")
                            val specialtyCode = resultSet.getString("SpecialityCode")
                            val specialtyName = resultSet.getString("SpecialityName")
                            val classStartTime = resultSet.getString("ClassStartTime")

                            classList.add(
                                Class(
                                    classCode,
                                    specialtyCode,
                                    classStartTime,
                                    specialtyName,
                                    className
                                )
                            )

                        }


                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return classList

    }

    override fun exactQuery(filterString: String): Class? {
        TODO("Not yet implemented")
    }

    fun editSelectorQuery(targetObject: Student): MutableList<Class> {

        val studentSpec = targetObject.classCode.substring(0, targetObject.classCode.length - 2)

        val sqlContext = "SELECT *FROM $tableName WHERE " +
                "ClassCode LIKE '$studentSpec%';"


        val classList: MutableList<Class> = mutableListOf()

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.executeQuery().use { resultSet ->


                        while (resultSet.next()) {

                            val classCode = resultSet.getString("ClassCode")
                            val className = resultSet.getString("ClassName")
                            val specialtyCode = resultSet.getString("SpecialityCode")
                            val specialtyName = resultSet.getString("SpecialityName")
                            val classStartTime = resultSet.getString("ClassStartTime")

                            classList.add(
                                Class(
                                    classCode,
                                    specialtyCode,
                                    classStartTime,
                                    specialtyName,
                                    className
                                )
                            )

                        }


                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return classList

    }

    override fun filterCount(fileType: String, filterString: String): Int {
        val sqlContext = "SELECT COUNT(*) FROM $tableName WHERE SpecialityCode = ?;"

        var count: Int = 0

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    it.setString(1, filterString)

                    it.executeQuery().use { resultSet ->

                        if (resultSet.next())
                            count = resultSet.getInt(1)

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return count
    }

    fun getClassCodeList():MutableList<String>{
        val sqlContext = "SELECT ? FROM $tableName;"

        val classCodeList:MutableList<String> = mutableListOf()

        try {

            getConnection()?.use { conn->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1,"ClassCode")

                    it.executeQuery()?.use { resultSet ->

                        while (resultSet.next()){

                            classCodeList.add(resultSet.getString(1))

                        }

                    }

                }

            }

        }catch (e:Exception){
            e.printStackTrace()
        }

        return classCodeList
    }
}