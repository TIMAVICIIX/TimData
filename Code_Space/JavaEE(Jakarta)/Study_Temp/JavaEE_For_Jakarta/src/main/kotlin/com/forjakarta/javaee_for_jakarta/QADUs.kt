package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.sql.*

@WebServlet(name = "Student", value = ["/Student"])
class QADUs : HttpServlet() {

//    private  lateinit var globalReq:HttpServletRequest
//    private lateinit var globalResp:HttpServletResponse


    private val rootName = "root"
    private val password = "123"
    private val jdbcPath = "jdbc:mysql://localhost:3306/test"


    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        super.doGet(req, resp)
    }

    init {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver")
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
    }

    private fun startLink(): Connection? {

        var connection: Connection? = null
//        var statement: Statement? = null

        try {

            connection = DriverManager.getConnection(jdbcPath, rootName, password)

        } catch (e: SQLException) {
            e.printStackTrace()
        }

        return connection

    }


    @MethodMapping(value = "/queryAllData")
    @Throws(SQLException::class)
    fun queryAllData(params:HttpServletRequest) {

        val queryConnection: Connection? = startLink()
        val queryString = "select * from test.student;"
        var preparedStatement: PreparedStatement? = null

        var resultSet: ResultSet? = null

        var studentList  = ArrayList<Student>()

        try {

            preparedStatement = queryConnection?.prepareStatement(queryString)!!

            resultSet = preparedStatement.executeQuery()

            while (resultSet.next()) {

                val studentID = resultSet.getString("ID")
                val studentName = resultSet.getString("Name")
                val studentBirthDay = resultSet.getString("Birth_Day")

//                print("ID:$studentID\nName:$studentName\nBirth_Day:$studentBirthDay\n")

                studentList.add(Student(studentID, studentName, studentBirthDay))

            }

        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            preparedStatement?.close()
            resultSet?.close()
            queryConnection?.close()
        }

        //DebugLog
        for(student in studentList){
            print("\n")
            student.displayData()
        }

    }


    @MethodMapping(value = "/insertData")
    @Throws(SQLException::class)
    fun insertData(params:HttpServletRequest){

        val insertID = params.getParameter("ID")
        val insertName = params.getParameter("Name")
        val insertBirthDay = params.getParameter("Birth_Day")
        val executeInsert = "insert into test.student(ID,Name,Birth_Day) values(?,?,?)"

        val insertConnection:Connection? = startLink()
        var insertStatement:PreparedStatement? = null

        try{
            insertStatement = insertConnection?.prepareStatement(executeInsert)!!

            insertStatement.run{

                setString(1,insertID)
                setString(2,insertName)
                setString(3,insertBirthDay)
                executeUpdate()

            }

            print("Insert Successful!")

        }catch (e:SQLException){
            e.printStackTrace()
        }finally {

            insertStatement?.close()
            insertConnection?.close()

        }

    }

    @MethodMapping(value = "/delete")
    @Throws(SQLException::class)
    fun deleteData(params:HttpServletRequest) {


        val deleteID: String? = params.getParameter("deleteID")

        var deleteConnection: Connection? = startLink()
        val executeDelete = "delete from test.student where $deleteID;"

        var deleteStatement: PreparedStatement? = null

        try {

            deleteStatement = deleteConnection?.prepareStatement(executeDelete)
            deleteStatement?.executeUpdate()

        } catch (e: SQLException) {
            e.printStackTrace()
        } finally {
            deleteStatement?.close()
            deleteConnection?.close()
        }
    }


    @MethodMapping(value = "/update")
    @Throws(SQLException::class)
    fun updateData(params: HttpServletRequest) {

        val updateID = params.getParameter("updateID")
        val updateName = params.getParameter("updateName")
        val updateBirth = params.getParameter("updateBirth")

        val updateConnection: Connection? = startLink()
        var updateStatement: PreparedStatement? = null


        val executeUpdate = "update test.student SET Name=?,Birth_Day=? where ID=?"

        try {

            updateStatement = updateConnection?.prepareStatement(executeUpdate)

            updateStatement?.run {

                setString(1, updateName)
                setString(2, updateBirth)
                setString(3, updateID)
                executeUpdate()
            }

        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            updateStatement?.close()
            updateConnection?.close()
        }

    }

}

