package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.dao_model.base.UserStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.ReadyAttend

class ReadyAttendDAO : BaseDao(), DaoStructMethod<ReadyAttend>, UserStructMethod<ReadyAttend> {

    override val tableName: String = "infoclass_readyattends"

    override fun save(targetObject: ReadyAttend): Boolean {
        val sqlContext =
            "INSERT INTO $tableName (attendCode, attendName, attendSex, enrollDate, targetCollege, targetSpec, targetClass, telephone, attendState, attendPassword)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);"

        getConnection()?.use { conn ->

            conn.prepareStatement(sqlContext)?.use {

                it.setString(1, targetObject.attendCode)
                it.setString(2, targetObject.attendName)
                it.setString(3, targetObject.attendSex)
                it.setString(4, targetObject.enrollDate)
                it.setString(5, targetObject.targetCollege)
                it.setString(6, targetObject.targetSpec)
                it.setString(7, targetObject.targetClass)
                it.setString(8, targetObject.telephone)
                it.setString(9, targetObject.attendState)
                it.setString(10, targetObject.attendPassword)

                it.executeUpdate()

                return true
            }

        }

        return false

    }

    override fun authCookie(authID: String): ReadyAttend? {
        TODO("Not yet implemented")
    }

    override fun setCookie(setTarget: ReadyAttend): String {
        TODO("Not yet implemented")
    }

    override fun getUserCodeList(): MutableList<String> {
        TODO("Not yet implemented")
    }

    override fun reSetPassword(userFilter: String, newPassword: String?): String {
        TODO("Not yet implemented")
    }

    override fun update(targetObject: ReadyAttend): Boolean {
        TODO("Not yet implemented")
    }

    override fun delete(deleteString: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun completeQuery(): MutableList<ReadyAttend> {
        TODO("Not yet implemented")
    }

    override fun filterQuery(filterString: String): MutableList<ReadyAttend> {
        TODO("Not yet implemented")
    }

    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<ReadyAttend> {
        TODO("Not yet implemented")
    }

    override fun exactQuery(filterString: String): ReadyAttend? {
        TODO("Not yet implemented")
    }

    override fun filterCount(fileType: String, filterString: String): Int {
        TODO("Not yet implemented")
    }
}