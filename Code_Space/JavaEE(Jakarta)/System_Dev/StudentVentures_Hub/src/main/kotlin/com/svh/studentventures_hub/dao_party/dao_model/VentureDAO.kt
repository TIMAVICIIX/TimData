package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.venture.Venture
import java.sql.ResultSet
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


class VentureDAO : BaseDao(), DaoStructMethod<Venture> {

    override val tableName = "ventureclass_ventures"

    override fun save(targetObject: Venture): Boolean {
        val sqlContext = "INSERT INTO " +
                "$tableName (VentureCode,VentureName,VentureStartDate" +
                ",VentureEndDate,VentureBelongCollege" +
                ",VentureBelongSpec,VentureBelongClass,VentureType,VentureDes)" +
                "VALUES (?,?,?,?,?,?,?,?,?);"


        try {

            getConnection()?.use { connection ->

                connection.prepareStatement(sqlContext).use {

                    it.setString(1, targetObject.ventureCode)
                    it.setString(2, targetObject.ventureName)
                    it.setString(3, targetObject.ventureStartDate)
                    it.setString(4, targetObject.ventureEndDate)
                    it.setString(5, targetObject.ventureBelongCollege)
                    it.setString(6, targetObject.ventureBelongSpec)
                    it.setString(7, targetObject.ventureBelongClass)
                    it.setString(8, targetObject.ventureType)
                    it.setString(9, targetObject.ventureDes)

                    it.executeUpdate()

                }


            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true
    }


    /**SQL WARRING**/
    override fun update(targetObject: Venture): Boolean {
        val sqlContext = " UPDATE " +
                "$tableName  SET VentureName=?,VentureStartDate=?,VentureEndDate=?," +
                "VentureBelongCollege=?,VentureBelongSpec=?,VentureBelongClass=?,VentureType=?,VentureDes=?" +
                "WHERE VentureCode=?;"
        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    it.setString(9, targetObject.ventureCode)
                    it.setString(1, targetObject.ventureName)
                    it.setString(2, targetObject.ventureStartDate)
                    it.setString(3, targetObject.ventureEndDate)
                    it.setString(4, targetObject.ventureBelongCollege)
                    it.setString(5, targetObject.ventureBelongSpec)
                    it.setString(6, targetObject.ventureBelongClass)
                    it.setString(7, targetObject.ventureType)
                    it.setString(8, targetObject.ventureDes)

                    it.executeUpdate()

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true

    }

    /**SQL WARRING**/
    override fun delete(deleteString: String): Boolean {
        val sqlContext = " DELETE FROM $tableName " +
                "WHERE VentureCode=? ;"

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

    override fun completeQuery(): MutableList<Venture> {
        val sqlContext = "SELECT * FROM $tableName;"

        val currentDate = Date()
        val resultVentures: MutableList<Venture> = mutableListOf()

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    val resultSet: ResultSet = it.executeQuery()

                    while (resultSet.next()) {

                        val ventureCode = resultSet.getString("VentureCode")
                        val ventureName = resultSet.getString("VentureName")
                        val ventureStartDate = resultSet.getString("VentureStartDate")
                        val ventureEndDate = resultSet.getString("VentureEndDate")
                        val ventureBelongCollege = resultSet.getString("VentureBelongCollege")
                        val ventureBelongSpec = resultSet.getString("VentureBelongSpec")
                        val ventureBelongClass = resultSet.getString("VentureBelongClass")
                        val ventureType = resultSet.getString("VentureType")
                        val ventureDes = resultSet.getString("ventureDes")

                        val ventureState: String =
                            if (currentDate.after(SimpleDateFormat("yyyy-MM-dd").parse(ventureStartDate))) {
                                "已放"
                            } else {
                                "未放"
                            }

                        resultVentures.add(
                            Venture(
                                ventureCode,
                                ventureName,
                                ventureStartDate,
                                ventureEndDate,
                                ventureBelongCollege,
                                ventureBelongSpec,
                                ventureBelongClass,
                                ventureType,
                                ventureDes,
                                ventureState
                            )
                        )

                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return resultVentures
    }

    override fun filterQuery(filterString: String): MutableList<Venture> {
        val sqlContext = "SELECT * FROM $tableName WHERE " +
                "VentureName LIKE '%$filterString%' OR " +
                "VentureStartDate LIKE '%$filterString%' OR " +
                "VentureEndDate LIKE '%$filterString%' OR " +
                "VentureBelongCollege LIKE '%$filterString%' OR " +
                "VentureBelongSpec LIKE '%$filterString%' OR " +
                "VentureBelongClass LIKE '%$filterString%' OR " +
                "VentureType LIKE '%$filterString%' OR " +
                "VentureDes LIKE '%$filterString%';"

        val resultVentures: MutableList<Venture> = mutableListOf()
        val currentDate = Date()


        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    val resultSet = it.executeQuery()

                    while (resultSet.next()) {

                        val ventureCode = resultSet.getString("VentureCode")
                        val ventureName = resultSet.getString("VentureName")
                        val ventureStartDate = resultSet.getString("VentureStartDate")
                        val ventureEndDate = resultSet.getString("VentureEndDate")
                        val ventureBelongCollege = resultSet.getString("VentureBelongCollege")
                        val ventureBelongSpec = resultSet.getString("VentureBelongSpec")
                        val ventureBelongClass = resultSet.getString("VentureBelongClass")
                        val ventureType = resultSet.getString("VentureType")
                        val ventureDes = resultSet.getString("ventureDes")

                        val ventureState: String =
                            if (currentDate.after(SimpleDateFormat("yyyy-MM-dd").parse(ventureStartDate))) {
                                "已放"
                            } else {
                                "未放"
                            }

                        resultVentures.add(
                            Venture(
                                ventureCode,
                                ventureName,
                                ventureStartDate,
                                ventureEndDate,
                                ventureBelongCollege,
                                ventureBelongSpec,
                                ventureBelongClass,
                                ventureType,
                                ventureDes,
                                ventureState
                            )
                        )

                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return resultVentures

    }


    /**DON'T CHANGE**/
    /**
     * @param filterString 假期号
     */
    override fun exactQuery(filterString: String): Venture? {
        val sqlContext = "SELECT * FROM $tableName WHERE VentureCode=?;"

        var venture: Venture? = null

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, filterString)
                    it.executeQuery()?.use { resultSet ->

                        while (resultSet.next()) {

                            val ventureCode = resultSet.getString("VentureCode")
                            val ventureName = resultSet.getString("VentureName")
                            val ventureStartDate = resultSet.getString("VentureStartDate")
                            val ventureEndDate = resultSet.getString("VentureEndDate")
                            val ventureBelongCollege = resultSet.getString("VentureBelongCollege")
                            val ventureBelongSpec = resultSet.getString("VentureBelongSpec")
                            val ventureBelongClass = resultSet.getString("VentureBelongClass")
                            val ventureType = resultSet.getString("VentureType")
                            val ventureDes = resultSet.getString("VentureDes")

                            venture = Venture(
                                ventureCode,
                                ventureName,
                                ventureStartDate,
                                ventureEndDate,
                                ventureBelongCollege,
                                ventureBelongSpec,
                                ventureBelongClass,
                                ventureType,
                                ventureDes, ""
                            )

                        }

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return venture

    }

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<Venture> {
        val sqlContext = if (identityToken == "52200") {
            "SELECT * FROM $tableName WHERE " +
                    "VentureCode LIKE '%$filterString%' OR " +
                    "VentureName LIKE '%$filterString%' OR " +
                    "VentureStartDate LIKE '%$filterString%' OR " +
                    "VentureEndDate LIKE '%$filterString%' OR " +
                    "VentureBelongCollege LIKE '%$filterString%' OR " +
                    "VentureBelongSpec LIKE '%$filterString%' OR " +
                    "VentureBelongClass LIKE '%$filterString%' OR " +
                    "VentureType LIKE '%$filterString%' OR " +
                    "VentureDes LIKE '%$filterString%';"
        } else {
            "SELECT * FROM $tableName WHERE( " +
                    "VentureCode LIKE '$identityToken%' AND (" +
                    "VentureStartDate LIKE '%$filterString%' OR " +
                    "VentureEndDate LIKE '%$filterString%' OR " +
                    "VentureBelongSpec LIKE '%$filterString%' OR " +
                    "VentureBelongClass LIKE '%$filterString%' OR " +
                    "VentureType LIKE '%$filterString%' OR " +
                    "VentureDes LIKE '%$filterString%'));"
        }

        val resultVentures: MutableList<Venture> = mutableListOf()
        val currentDate = Date()

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    val resultSet = it.executeQuery()

                    while (resultSet.next()) {

                        val ventureCode = resultSet.getString("VentureCode")
                        val ventureName = resultSet.getString("VentureName")
                        val ventureStartDate = resultSet.getString("VentureStartDate")
                        val ventureEndDate = resultSet.getString("VentureEndDate")
                        val ventureBelongCollege = resultSet.getString("VentureBelongCollege")
                        val ventureBelongSpec = resultSet.getString("VentureBelongSpec")
                        val ventureBelongClass = resultSet.getString("VentureBelongClass")
                        val ventureType = resultSet.getString("VentureType")
                        val ventureDes = resultSet.getString("ventureDes")

                        val ventureState: String =
                            if (currentDate.after(SimpleDateFormat("yyyy-MM-dd").parse(ventureStartDate))) {
                                "已放"
                            } else {
                                "未放"
                            }

                        resultVentures.add(
                            Venture(
                                ventureCode,
                                ventureName,
                                ventureStartDate,
                                ventureEndDate,
                                ventureBelongCollege,
                                ventureBelongSpec,
                                ventureBelongClass,
                                ventureType,
                                ventureDes,
                                ventureState
                            )
                        )

                    }

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return resultVentures
    }

    /**
     * @param filterString 学号
     * @param fileType 班级号
     */

    override fun filterCount(fileType: String, filterString: String): Int {

        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = currentDate.format(formatter)

        val studentHistoryRecord = VentureRecordDAO().getStuRecordString(filterString)

        val classFilter = fileType.take(fileType.length - 4) + "0000"
        val specFilter = fileType.take(fileType.length - 6) + "000000"
        val collegeFilter = fileType.take(fileType.length - 8) + "00000000"

        val sqlContext = if (studentHistoryRecord == "") {
            "SELECT COUNT(*) FROM $tableName WHERE VentureEndDate > '$formattedDate' " +
                    "AND (VentureCode LIKE '$fileType%' OR VentureCode LIKE '${classFilter}%' OR VentureCode LIKE '${specFilter}%' OR VentureCode LIKE '${collegeFilter}%');"
        } else {
            "SELECT COUNT(*) FROM $tableName WHERE VentureEndDate > '$formattedDate' " +
                    "AND (('$studentHistoryRecord' NOT LIKE CONCAT('%',VentureCode,'%')) " +
                    "AND (VentureCode LIKE '$fileType%' OR VentureCode LIKE '${classFilter}%' OR VentureCode LIKE '${specFilter}%' OR VentureCode LIKE '${collegeFilter}%'));"
        }


        var resultCount = 0

//        println(sqlContext)

        try {

            getConnection()?.prepareStatement(sqlContext)?.use {

//                it.setString(1, filterString)
                it.executeQuery()?.use { resultSet ->

                    while (resultSet.next()) {
                        resultCount = resultSet.getInt(1)
                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return resultCount

    }

    /**
     * @param fileType 班级号
     * @param filterString 查询类型:LIMIT_DATE,LIMITLESS_DATE
     */

    fun stuFilterGetVentures(fileType: String, filterString: String): MutableList<Venture> {

        val currentDate = LocalDate.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = currentDate.format(formatter)

        val classFilter = fileType.take(fileType.length - 4) + "0000"
        val specFilter = fileType.take(fileType.length - 6) + "000000"
        val collegeFilter = fileType.take(fileType.length - 8) + "00000000"

        val sqlContext = if (filterString == "LIMIT_DATE") {
            "SELECT * " +
                    "FROM $tableName " +
                    "WHERE VentureEndDate > '$formattedDate' " +
                    "  AND (VentureCode LIKE '$fileType%' " +
                    "OR VentureCode LIKE '${classFilter}%' " +
                    "OR VentureCode LIKE '${specFilter}%' " +
                    "OR VentureCode LIKE '${collegeFilter}%' );"
        } else {
            "SELECT * " +
                    "FROM $tableName " +
                    "WHERE " +
                    "VentureCode LIKE '$fileType%' " +
                    "OR VentureCode LIKE '${classFilter}%' " +
                    "OR VentureCode LIKE '${specFilter}%' " +
                    "OR VentureCode LIKE '${collegeFilter}%';"
        }


        val ventureList: MutableList<Venture> = mutableListOf()

        getConnection()?.prepareStatement(sqlContext)?.executeQuery()?.use { resultSet ->

            while (resultSet.next()) {

                val ventureCode = resultSet.getString("VentureCode")
                val ventureName = resultSet.getString("VentureName")
                val ventureStartDate = resultSet.getString("VentureStartDate")
                val ventureEndDate = resultSet.getString("VentureEndDate")
                val ventureBelongCollege = resultSet.getString("VentureBelongCollege")
                val ventureBelongSpec = resultSet.getString("VentureBelongSpec")
                val ventureBelongClass = resultSet.getString("VentureBelongClass")
                val ventureType = resultSet.getString("VentureType")
                val ventureDes = resultSet.getString("ventureDes")

                val ventureState: String =
                    if (LocalDate.parse(ventureEndDate, formatter) < currentDate) {
                        "已过期"
                    } else {
                        "未过期"
                    }

                ventureList.add(
                    Venture(
                        ventureCode,
                        ventureName,
                        ventureStartDate,
                        ventureEndDate,
                        ventureBelongCollege,
                        ventureBelongSpec,
                        ventureBelongClass,
                        ventureType,
                        ventureDes,
                        ventureState
                    )
                )

            }

        }


        return ventureList
    }
}