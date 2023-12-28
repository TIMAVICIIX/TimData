package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.Speciality

class SpecialityDAO : BaseDao(), DaoStructMethod<Speciality> {

    override val tableName: String = "infoclass_specialitys"

    override fun save(targetObject: Speciality): Boolean {
        val sqlContext = "INSERT INTO $tableName(SpecialityCode,CollegeCode,SpecialityName) " +
                "VALUES(?,?,?)"


        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.specialityCode)
                    it.setString(2, targetObject.collegeCode)
                    it.setString(3, targetObject.specialityName)

                    it.executeUpdate()

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true

    }

    override fun update(targetObject: Speciality): Boolean {
        val sqlContext = "UPDATE $tableName SET SpecialityName=? WHERE SpecialityCode=?"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.specialityName)
                    it.setString(2, targetObject.specialityCode)

                    it.executeUpdate()
                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true

    }

    override fun delete(deleteString: String): Boolean {
        val sqlContext = "DELETE FROM $tableName WHERE SpecialityCode=$deleteString"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.executeUpdate()
            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }
        return true

    }

    override fun completeQuery(): MutableList<Speciality> {
        TODO("Not yet implemented")
    }

    override fun filterQuery(filterString: String): MutableList<Speciality> {
        TODO("Not yet implemented")
    }

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<Speciality> {
        var sqlContext = "SELECT * FROM $tableName WHERE( CollegeCode='$identityToken' AND(" +
                "SpecialityCode LIKE '%$filterString%' OR SpecialityName LIKE '%$filterString%'));"

        if (identityToken == "52200") {

            sqlContext = "SELECT * FROM $tableName WHERE (CollegeCode LIKE '%$filterString%' OR " +
                    "SpecialityName LIKE '%$filterString%' OR SpecialityName LIKE '%$filterString%');"

        }

        val specialityList: MutableList<Speciality> = mutableListOf()

        try {

            getConnection()?.prepareStatement(sqlContext)?.use {

                it.executeQuery().use { resultSet ->

                    var specCode = ""
                    var collegeCode = ""
                    var specName = ""

                    while (resultSet.next()) {

                        specCode = resultSet.getString("SpecialityCode")
                        collegeCode = resultSet.getString("CollegeCode")
                        specName = resultSet.getString("SpecialityName")

                        specialityList.add(
                            Speciality(specCode, collegeCode, specName)
                        )

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return specialityList
    }

    override fun exactQuery(filterString: String): Speciality? {
        TODO("Not yet implemented")
    }

    override fun filterCount(fileType: String, filterString: String): Int {
        val sqlContext = "SELECT COUNT(*) FROM $tableName WHERE CollegeCode = ?;"

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

    fun getSpecCodeList(): MutableList<String> {
        val sqlContext = "SELECT ? FROM ?;"

        val specCodeList: MutableList<String> = mutableListOf()

        try {
            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, "SpecialityCode")
                    it.setString(2, tableName)

                    it.executeQuery()?.use { resultSet ->

                        specCodeList.add(resultSet.getString(1))

                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return specCodeList
    }

}