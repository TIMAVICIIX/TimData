package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.Poster

class PosterDAO : BaseDao(), DaoStructMethod<Poster> {

    override val tableName: String = "infoclass_posters"

    override fun save(targetObject: Poster): Boolean {
        val sqlContext = "INSERT INTO $tableName(PosterCode,PosterName,ManagerTarget,password) " +
                "VALUES(?,?,?,?)"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.posterCode)
                    it.setString(2, targetObject.posterName)
                    it.setString(3, targetObject.managerTarget)
                    it.setString(4, targetObject.password)

                    it.executeUpdate()

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return true

    }

    override fun update(targetObject: Poster): Boolean {
        val sqlContext = "UPDATE $tableName SET " +
                " PosterName=?,ManagerTarget=?,password=? WHERE PosterCode=?;"

        try {
            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.posterName)
                    it.setString(2, targetObject.managerTarget)
                    it.setString(3, targetObject.password)

                    it.executeUpdate()

                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return true
    }

    override fun delete(deleteString: String): Boolean {
        val sqlContext = "DELETE FROM $tableName WHERE " +
                "PosterCode=?;"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, deleteString)

                    it.executeUpdate()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return true

    }


    /**DON'T CHANGE**/
    override fun completeQuery(): MutableList<Poster> {
        TODO("Not yet implemented")
    }


    /**DON'T CHANGE**/
    override fun filterQuery(filterString: String): MutableList<Poster> {
        TODO("Not yet implemented")
    }

    override fun exactQuery(filterString: String): Poster? {
        val sqlContext = "SELECT * FROM " +
                "$tableName WHERE PosterCode=?;"

        var exactPoster: Poster? = null

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, filterString)

                    it.executeQuery().use { resultSet ->

                        while (resultSet.next()) {
                            val posterCode = resultSet.getString("PosterCode")
                            val posterName = resultSet.getString("PosterName")
                            val managerTarget = resultSet.getString("ManageTarget")
                            val password = resultSet.getString("password")

                            exactPoster = Poster(posterCode, posterName, managerTarget, password)
                        }

                        return exactPoster

                    }

                }

            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return null
    }
}