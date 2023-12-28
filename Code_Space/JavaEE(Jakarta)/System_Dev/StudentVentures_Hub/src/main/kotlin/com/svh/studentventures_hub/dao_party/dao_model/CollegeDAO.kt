package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.College
import com.svh.studentventures_hub.dao_party.object_model.info.Speciality

class CollegeDAO : BaseDao(), DaoStructMethod<College> {

    override val tableName: String = "infoclass_colleges"

    override fun save(targetObject: College): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(targetObject: College): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(deleteString: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun completeQuery(): MutableList<College> {
        val sqlContext = "SELECT * FROM $tableName;"

        val collegeList: MutableList<College> = mutableListOf()

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.executeQuery().use { resultSet ->

                        while (resultSet.next()) {

                            val collegeCode = resultSet.getString("CollegeCode")
                            val collegeName = resultSet.getString("CollegeName")

                            collegeList.add(College(collegeCode, collegeName))

                        }

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return collegeList
    }

    override fun filterQuery(filterString: String): MutableList<College> {
        TODO("Not yet implemented")
    }

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<College> {
        var sqlContext = "SELECT * FROM $tableName WHERE( CollegeCode='$identityToken' AND(" +
                "CollegeName LIKE '%$filterString%'));"

        if (identityToken == "52200") {

            sqlContext = "SELECT * FROM $tableName WHERE CollegeCode LIKE '%$filterString%' OR " +
                    "CollegeName LIKE '%$filterString%';"

        }

        val collegeList: MutableList<College> = mutableListOf()

        try {

            getConnection()?.prepareStatement(sqlContext)?.use {

                it.executeQuery().use { resultSet ->

                    var collegeCode = ""
                    var collegeName = ""

                    while (resultSet.next()) {

                        collegeCode = resultSet.getString("CollegeCode")
                        collegeName = resultSet.getString("CollegeName")

                        collegeList.add(
                            College(collegeCode,collegeName)
                        )

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return collegeList
    }

    override fun exactQuery(filterString: String): College? {
        val sqlContext = "SELECT * FROM $tableName WHERE CollegeCode=?;"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, filterString)

                    it.executeQuery().use { resultSet ->

                        var collegeName = ""
                        var collegeCode = ""

                        while (resultSet.next()) {

                            collegeName = resultSet.getString("CollegeName")
                            collegeCode = resultSet.getString("CollegeCode")

                        }
                        return College(collegeCode, collegeName)
                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null

    }

    override fun filterCount(fileType:String,filterString: String): Int {
        TODO("Not yet implemented")
    }

    fun getComplexCount():Int{
        val sqlContext =  "SELECT COUNT(*) FROM $tableName"

        var count=0;

        getConnection()?.use { conn->
            conn.prepareStatement(sqlContext)?.use {
                it.executeQuery()?.use { resultSet ->

                    while (resultSet.next()){
                        count = resultSet.getInt(1)
                    }

                }
            }
        }

        return count
    }
}