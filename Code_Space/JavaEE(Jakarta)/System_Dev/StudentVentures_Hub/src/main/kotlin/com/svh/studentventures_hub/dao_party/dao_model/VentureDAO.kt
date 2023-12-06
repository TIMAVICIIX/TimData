package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.venture.Venture
import java.sql.ResultSet
import java.text.SimpleDateFormat
import java.util.*


class VentureDAO : BaseDao(), DaoStructMethod<Venture> {

    override val tableName = "ventureclass_ventures"

    override fun save(targetObject: Venture): Boolean {
        val sqlContext = "INSERT INTO " +
                "$tableName (VentureCode,VentureName,VentureStartDate,VentureEndDate,VentureBelong,VentureDes)" +
                "VALUES (?,?,?,?,?,?);"


        try {

            getConnection()?.use { connection ->

                connection.prepareStatement(sqlContext).use {

                    it.setString(1, targetObject.ventureCode)
                    it.setString(2, targetObject.ventureName)
                    it.setString(3, targetObject.ventureStartDate)
                    it.setString(4, targetObject.ventureEndDate)
                    it.setString(5, targetObject.ventureBelong)
                    it.setString(6, targetObject.ventureDes)

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
                "$tableName  SET VentureName=?,VentureStartDate=?,VentureEndDate=?,VentureBelong=?,VentureDes=?" +
                "WHERE VentureCode=?;"
        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    it.setString(1, targetObject.ventureName)
                    it.setString(2, targetObject.ventureStartDate)
                    it.setString(3, targetObject.ventureEndDate)
                    it.setString(4, targetObject.ventureBelong)
                    it.setString(5, targetObject.ventureDes)

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
                        val ventureBelong = resultSet.getString("VentureBelong")
                        val ventureDes = resultSet.getString("ventureDes")

                        val ventureState: String =
                            if (currentDate.after(SimpleDateFormat("yyyyMMdd").parse(ventureCode))) {
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
                                ventureBelong,
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
                "VentureBelong LIKE '%$filterString%' OR " +
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
                        val ventureBelong = resultSet.getString("VentureBelong")
                        val ventureDes = resultSet.getString("ventureDes")

                        val ventureState: String =
                            if (currentDate.after(SimpleDateFormat("yyyyMMdd").parse(ventureCode))) {
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
                                ventureBelong,
                                ventureDes,
                                ventureState
                            )
                        )

                    }

                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return resultVentures

    }


    /**DON'T CHANGE**/
    override fun exactQuery(filterString: String): Venture? {
        TODO("Not yet implemented")
    }

}