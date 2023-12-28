package com.svh.studentventures_hub.dao_party.dao_model

import com.svh.studentventures_hub.dao_party.dao_model.base.BaseDao
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.dao_model.base.UserStructMethod
import com.svh.studentventures_hub.dao_party.object_model.info.Student


/**
 *
 * StudentCode
 * ClassCode
 * StudentName
 * StudentSex
 * Telephone
 * password
 * StudentState
 * CookieCode
 *
 **/

class StudentDAO : BaseDao(), DaoStructMethod<Student>, UserStructMethod<Student> {

    override val tableName: String = "infoclass_students"
    override fun save(targetObject: Student): Boolean {
        val sqlContext =
            "INSERT INTO $tableName(StudentCode,ClassCode,CollegeName,ClassName,StudentName,StudentSex,EnrollTime,Telephone,password,StudentState,CookieCode)" +
                    " VALUES(?,?,?,?,?,?,?,?,?,?,?);"

        try {
            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.studentCode)
                    it.setString(2, targetObject.classCode)
                    it.setString(3, targetObject.collegeName)
                    it.setString(4, targetObject.className)
                    it.setString(5, targetObject.studentName)
                    it.setString(6, targetObject.studentSex)
                    it.setString(7, targetObject.enrollTime)
                    it.setString(8, targetObject.telephone)
                    it.setString(9, targetObject.password)
                    it.setString(10, targetObject.studentState)
                    it.setString(11, generateCookieCode())

                    it.executeUpdate()
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true
    }

    override fun update(targetObject: Student): Boolean {
        val sqlContext = "UPDATE $tableName SET " +
                "ClassCode=?,CollegeName=?,ClassName=?,StudentName=?,StudentSex=?,EnrollTime=?,Telephone=?,password=?,StudentState=?,CookieCode=? WHERE StudentCode=?;"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, targetObject.classCode)
                    it.setString(2, targetObject.collegeName)
                    it.setString(3, targetObject.classCode)
                    it.setString(4, targetObject.studentName)
                    it.setString(5, targetObject.studentSex)
                    it.setString(6, targetObject.enrollTime)
                    it.setString(7, targetObject.telephone)
                    it.setString(8, targetObject.password)
                    it.setString(9, targetObject.studentState)
                    it.setString(10, targetObject.cookieCode)
                    it.setString(11, targetObject.studentCode)

                    it.executeUpdate()
                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
            return false
        }

        return true
    }

    fun normalUpdate(
        targetInfoKey: String,
        studentName: String,
        studentSex: String,
        studentClassCode: String,
        studentClassName: String,
        studentTelephone: String
    ): Boolean {

        val sqlContext =
            "UPDATE $tableName SET StudentName=?,StudentSex=?,ClassCode=?,ClassName=?,Telephone=? WHERE StudentCode=?;"

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {
                    it.setString(1, studentName)
                    it.setString(2, studentSex)
                    it.setString(3, studentClassCode)
                    it.setString(4, studentClassName)
                    it.setString(5, studentTelephone)
                    it.setString(6, targetInfoKey)

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
        val sqlContext = "DELETE FROM $tableName WHERE " +
                "StudentCode=?;"

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

    /**DON'T CHANGE**/
    override fun completeQuery(): MutableList<Student> {
        TODO("Not yet implemented")
    }

    /**STUDENT AUTH QUERY**/
    /**identityToken is MangerBelong**/
    override fun authFilterQuery(identityToken: String, filterString: String): MutableList<Student> {

        var querySqlContext = "SELECT * FROM $tableName WHERE (" +
                "ClassCode LIKE '$identityToken%' AND (" +
                "StudentCode LIKE '%$filterString%' OR " +
                "ClassName LIKE '%$filterString%' OR " +
                "EnrollTime LIKE '%$filterString%' OR " +
                "StudentName LIKE '%$filterString%' OR " +
                "StudentSex LIKE '%$filterString%' OR " +
                "Telephone LIKE '%$filterString%' OR " +
                "StudentState LIKE '%$filterString%'));"

        if (identityToken == "52200") {

            querySqlContext = "SELECT * FROM $tableName WHERE " +
                    "StudentCode LIKE '%$filterString%' OR " +
                    "CLassCode LIKE '%$filterString%' OR " +
                    "StudentName LIKE '%$filterString%' OR " +
                    "StudentSex LIKE '%$filterString%' OR " +
                    "Telephone LIKE '%$filterString%' OR " +
                    "ClassName LIKE '%$filterString%' OR " +
                    "CollegeName LIKE '%$filterString%' OR " +
                    "EnrollTime LIKE '%$filterString%' OR " +
                    "StudentState LIKE '%$filterString%';"

        }


        val resultStudents: MutableList<Student> = mutableListOf()

        try {

            getConnection()?.use { conn ->


                conn.prepareStatement(querySqlContext).use {

                    it.executeQuery()?.use { resultSet ->

                        while (resultSet.next()) {
                            val studentCode = resultSet.getString("StudentCode")
                            val classCode = resultSet.getString("ClassCode")
                            val collegeName = resultSet.getString("CollegeName")
                            val className = resultSet.getString("ClassName")
                            val studentName = resultSet.getString("StudentName")
                            val studentSex = resultSet.getString("StudentSex")
                            val enrollTime = resultSet.getString("EnrollTime")
                            val telephone = resultSet.getString("Telephone")
                            val password = resultSet.getString("password")
                            val studentState = resultSet.getString("StudentState")
                            val cookieCode = resultSet.getString("CookieCode")

                            resultStudents.add(
                                Student(
                                    studentCode,
                                    classCode,
                                    collegeName,
                                    className,
                                    studentName,
                                    studentSex,
                                    enrollTime,
                                    telephone,
                                    password,
                                    studentState,
                                    cookieCode
                                )
                            )

                        }

                    }

                }

            }


        } catch (e: Exception) {
            e.printStackTrace()
        }

        return resultStudents
    }

    override fun exactQuery(filterString: String): Student? {
        val sqlContext = "SELECT * FROM " +
                "$tableName WHERE StudentCode=?;"

        var exactStudent: Student? = null

        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext).use {

                    it.setString(1, filterString)

                    it.executeQuery().use { resultSet ->

                        while (resultSet.next()) {
                            val studentCode = resultSet.getString("StudentCode")
                            val classCode = resultSet.getString("ClassCode")
                            val collegeName = resultSet.getString("CollegeName")
                            val className = resultSet.getString("ClassName")
                            val studentName = resultSet.getString("StudentName")
                            val studentSex = resultSet.getString("StudentSex")
                            val enrollTime = resultSet.getString("EnrollTime")
                            val telephone = resultSet.getString("Telephone")
                            val password = resultSet.getString("password")
                            val studentState = resultSet.getString("StudentState")
                            val cookieCode = resultSet.getString("CookieCode")

                            exactStudent = Student(
                                studentCode,
                                classCode,
                                collegeName,
                                className,
                                studentName,
                                studentSex,
                                enrollTime,
                                telephone,
                                password,
                                studentState,
                                cookieCode
                            )


                        }

                        return exactStudent
                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    override fun authCookie(authID: String): Student? {
        val sqlContext = "SELECT * FROM $tableName WHERE CookieCode=?;"


        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, authID)
                    it.executeQuery().use { resultSet ->

                        while (resultSet.next()) {

                            val studentCode = resultSet.getString("StudentCode")
                            val studentName = resultSet.getString("StudentName")
                            val studentClass = resultSet.getString("ClassCode")

                            return Student(studentCode, studentClass, studentName, "", "", "", "", "", "", "", "")

                        }

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null

    }

    override fun setCookie(setTarget: Student): String {
        val sqlContext = "UPDATE $tableName SET CookieCode=? WHERE StudentCode=?;"

        try {
            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {
                    val cookieCode = generateCookieCode()

                    it.setString(1, cookieCode)
                    it.setString(2, setTarget.cookieCode)

                    it.executeUpdate()

                    return cookieCode
                }

            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return "false"
    }

    /**
     * @param filterString 班级号
     */
    override fun filterQuery(filterString: String): MutableList<Student> {
        val sqlContext = "SELECT * FROM $tableName WHERE ClassCode LIKE ?;"

        val studentList = mutableListOf<Student>()

        getConnection()?.use { conn ->
            conn.prepareStatement(sqlContext).use {
                it.setString(1, "$filterString%")
                it.executeQuery()?.use { resultSet ->

                    while (resultSet.next()) {
                        val studentCode = resultSet.getString("StudentCode")
                        val classCode = resultSet.getString("ClassCode")
                        val collegeName = resultSet.getString("CollegeName")
                        val className = resultSet.getString("ClassName")
                        val studentName = resultSet.getString("StudentName")
                        val studentSex = resultSet.getString("StudentSex")
                        val enrollTime = resultSet.getString("EnrollTime")
                        val telephone = resultSet.getString("Telephone")
                        val password = resultSet.getString("password")
                        val studentState = resultSet.getString("StudentState")
                        val cookieCode = resultSet.getString("CookieCode")

                        studentList.add(
                            Student(
                                studentCode,
                                classCode,
                                collegeName,
                                className,
                                studentName,
                                studentSex,
                                enrollTime,
                                telephone,
                                password,
                                studentState,
                                cookieCode
                            )
                        )


                    }

                }
            }
        }

        return studentList

    }

    override fun filterCount(fileType: String, filterString: String): Int {

        val sqlContext = when (filterString) {
            "CLASS" -> "SELECT COUNT(*) FROM $tableName WHERE ClassCode=$filterString;"
            else -> "SELECT COUNT(*) FROM $tableName WHERE ClassCode LIKE '$filterString%';"
        }


        var count = 0

        try {

            getConnection()?.use { conn ->

                //DEBUG LOG
//                println(sqlContext)

                conn.prepareStatement(sqlContext).use {

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

    override fun getUserCodeList(): MutableList<String> {
        val sqlContext = "SELECT ? FROM $tableName;"


        val studentCodeList: MutableList<String> = mutableListOf()
        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, "StudentCode")

                    it.executeQuery()?.use { resultSet ->

                        while (resultSet.next()) {
                            val studentCode = resultSet.getString("StudentCode").toString()
                            studentCodeList.add(studentCode)
                        }

                    }

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return studentCodeList
    }

    override fun reSetPassword(userFilter: String, newPassword: String?): String {
        val sqlContext = "UPDATE $tableName SET password=? WHERE StudentCode=?;"

        val currentPassword = newPassword ?: generatePassword()


        try {

            getConnection()?.use { conn ->

                conn.prepareStatement(sqlContext)?.use {

                    it.setString(1, currentPassword)
                    it.setString(2, userFilter)

                    it.executeUpdate()

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return currentPassword
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
