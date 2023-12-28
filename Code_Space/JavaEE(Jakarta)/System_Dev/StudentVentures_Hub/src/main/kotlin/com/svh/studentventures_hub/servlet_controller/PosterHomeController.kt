package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.*
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoTools.Companion.toStringOrBlank
import com.svh.studentventures_hub.dao_party.object_model.info.Class
import com.svh.studentventures_hub.dao_party.object_model.info.College
import com.svh.studentventures_hub.dao_party.object_model.info.Speciality
import com.svh.studentventures_hub.dao_party.object_model.info.Student
import com.svh.studentventures_hub.dao_party.object_model.venture.Venture
import com.svh.studentventures_hub.listener.SessionManager
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFCell
import org.apache.poi.xssf.usermodel.XSSFRow
import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import java.time.LocalDate
import java.time.Year
import java.time.format.DateTimeFormatter
import kotlin.random.Random


@WebServlet(name = "PosterHomeController", value = ["/poster_home-controller"])
class PosterHomeController : HttpServlet() {


    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

        when (req?.getParameter("action")) {
            "downloadVentureCollect" -> downloadCollect(req, resp)
        }
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

        when (req?.getParameter("action")) {
            "query" -> queryBus(req, resp)
            "edit" -> editBus(req, resp)
            "update" -> updateEditItem(req, resp)
            "save" -> saveBus(req, resp)
            "saveRequest" -> getSaveRequestInfo(req, resp)
            "risk" -> riskBus(req, resp)
        }
    }

    private fun queryBus(req: HttpServletRequest?, resp: HttpServletResponse?) {
        when (req?.getParameter("queryType")) {
            "student" -> getStudentTable(req, resp)
            "class" -> getClassTable(req, resp)
            "spec" -> getSpecTable(req, resp)
            "college" -> getCollegeTable(req, resp)
            "venture" -> getVentureTable(req, resp)
            "ventureCollectList" -> getVentureCollectList(req, resp)
        }
    }

    private fun editBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        when (req?.getParameter("editType")) {
            "studentInfo" -> getStudentEditItem(req, resp)
            "ventureInfo" -> getEditVenture(req, resp)
            "ventureCollectItem" -> getVentureCollectAndInfo(req, resp)
        }

    }

    private fun riskBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        when (req?.getParameter("riskDataList[riskType]")) {
            "resetStudentPassword" -> resetStudentPassword(req, resp)
            "resetUserPassword" -> reSetUserPassword(req, resp)
            "delete" -> deleteInfo(req, resp)
            else -> {
                resp?.writer?.apply {
                    print("401")
                    flush()
                    return
                }

            }
        }

    }

    private fun saveBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                println("SAVING")

                when (it.getParameter("saveDataList[saveType]")) {
                    "student" -> {

                        val studentName = it.getParameter("saveDataList[saveName]").toString()
                        val studentSex = it.getParameter("saveDataList[saveSex]").toString()
                        val studentCollege = it.getParameter("saveDataList[saveCollege]").toString()
                        val studentClassCode = it.getParameter("saveDataList[saveClassCode]").toString()
                        val studentClassName = it.getParameter("saveDataList[saveClassName]").toString()
                        val studentTelephone = it.getParameter("saveDataList[saveTelephone]").toString()
                        val enrollTime = it.getParameter("saveDataList[saveTime]").toString()

                        val studentDao = StudentDAO()
                        val studentCodeList = studentDao.getUserCodeList()
                        val studentPassword = studentDao.generatePassword()

                        val studentCodePart = studentClassCode.substring(2)
                        var studentCode: String

                        do {
                            val studentCodeEnd = Random.nextInt(10, 100).toString()
                            studentCode = studentCodePart + studentCodeEnd
                            val existCode = studentCode in studentCodeList
                        } while (existCode)

                        val studentObject = Student(
                            studentCode,
                            studentClassCode,
                            studentCollege,
                            studentClassName,
                            studentName,
                            studentSex,
                            enrollTime,
                            studentTelephone,
                            studentPassword,
                            "正常",
                            studentDao.generateCookieCode()
                        )


                        resp?.writer?.apply {
                            if (studentDao.save(studentObject)) {
                                print("账号:$studentCode\n密码:$studentPassword")
                                flush()
                                return
                            } else {
                                print("417")
                                flush()
                                return
                            }
                        }

                    }

                    "class" -> {

                        var className = it.getParameter("saveDataList[saveName]")
                        val classSpecCode = it.getParameter("saveDataList[saveSpecCode]")
                        val classSpecName = it.getParameter("saveDataList[saveSpecName]")
                        val saveTime = it.getParameter("saveDataList[saveTime]")

                        val classCodePart = classSpecCode + saveTime.substring(2)

                        val classDAO = ClassDAO()
                        val classCodeList = classDAO.getClassCodeList()

                        var classCode: String

                        do {
                            classCode = classCodePart + Random.nextInt(10, 100).toString()
                            val existCode = classCode in classCodeList
                        } while (existCode)

                        className = "B${saveTime.substring(2)}" + className

                        val classObject = Class(classCode, classSpecCode, saveTime, classSpecName, className)

                        //DEBUG LOG
//                        println("CLASS CODE:$classCode\nCLASS SPEC CODE:$classSpecCode\n" +
//                                "SAVE TIME:$saveTime\nCLASS SPEC NAME:$classSpecName\nCLASS NAME:$className")

                        resp?.writer?.apply {
                            if (classDAO.save(classObject)) {
                                print("班级代号:$classCode\n班级名称:$className")
                                flush()
                                return
                            } else {
                                print("417")
                                flush()
                                return
                            }
                        }
                    }

                    "spec" -> {

                        val specName = it.getParameter("saveDataList[saveName]")
                        val specCollegeCode = it.getParameter("saveDataList[saveCollegeCode]")

                        val specDAO = SpecialityDAO()
                        val specCodeList = specDAO.getSpecCodeList()

                        var specCode: String

                        do {

                            specCode = specCollegeCode + Random.nextInt(10, 100).toString()
                            val existCode = specCode in specCodeList

                        } while (existCode)

                        //DEBUG LOG
//                        println("SPEC CODE:$specCode\nSPEC COLLEGE CODE:$specCollegeCode\nSPEC NAME:$specName")

                        val specObject = Speciality(specCode, specCollegeCode, specName)

                        resp?.writer?.apply {
                            if (specDAO.save(specObject)) {
                                print("专业代号:$specCode\n专业名称:$specName")
                                flush()
                                return
                            } else {
                                print("417")
                                flush()
                                return
                            }
                        }

                    }

                    "venture" -> {
                        val ventureName = it.getParameter("saveDataList[ventureName]")
                        val ventureStartDate = it.getParameter("saveDataList[ventureStartDate]")
                        val ventureEndDate = it.getParameter("saveDataList[ventureEndDate]")
                        val ventureBelongCollege = it.getParameter("saveDataList[ventureBelongCollege]")
                        val ventureBelongSpec = it.getParameter("saveDataList[ventureBelongSpec]")
                        val ventureBelongClass = it.getParameter("saveDataList[ventureBelongClass]")
                        val ventureType = it.getParameter("saveDataList[ventureType]")
                        val ventureDes = it.getParameter("saveDataList[ventureDes]")

                        val ventureBelongCollegeCode = it.getParameter("saveDataList[ventureBelongCollegeCode]")
                        val ventureBelongSpecCode = it.getParameter("saveDataList[ventureBelongSpecCode]")
                        val ventureBelongClassCode = it.getParameter("saveDataList[ventureBelongClassCode]")

                        val ventureDAO = VentureDAO()

                        var ventureCode = if (ventureBelongCollegeCode == "全体学院") {
                            "52200000000"
                        } else if (ventureBelongSpecCode == "全体专业") {
                            "${ventureBelongCollegeCode}000000"
                        } else if (ventureBelongClassCode == "全体班级") {
                            "${ventureBelongSpecCode}0000"
                        } else {
                            ventureBelongClassCode
                        }

                        ventureCode += ventureStartDate.substring(2, 4) +
                                ventureStartDate.substring(5, 7) +
                                ventureStartDate.substring(8)

                        val ventureObject = Venture(
                            ventureCode,
                            ventureName,
                            ventureStartDate,
                            ventureEndDate,
                            ventureBelongCollege,
                            ventureBelongSpec,
                            ventureBelongClass,
                            ventureType,
                            ventureDes,
                            null
                        )

                        resp?.writer?.apply {
                            if (ventureDAO.save(ventureObject)) {
                                print(
                                    "假期号:$ventureCode\n假期名称:$ventureName\n假期时间:$ventureStartDate->$ventureEndDate\n" +
                                            "假期所属:$ventureBelongCollege:$ventureBelongSpec:$ventureBelongClass\n"
                                )
                                flush()
                                return
                            } else {
                                print("417")
                                flush()
                                return
                            }
                        }

                    }

                    else -> {
                        resp?.writer?.apply {
                            print("417")
                            flush()
                            return
                        }
                    }
                }


            }
        }
        resp?.writer?.apply {
            print("417")
            flush()
            return
        }
    }


    private fun getStudentTable(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var tableString = ""

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {
                val posterBelongID = it.getParameter("posterBelongID").toString()
                val filterString = it.getParameter("filter").toString()

                val studentList = StudentDAO().authFilterQuery(posterBelongID, filterString)
                for (student in studentList) {

                    tableString += "<tr class=\"body_tr\">"

                    val currentYear = Year.now().value
                    val studentRank = currentYear - student.enrollTime.toInt()

                    tableString += "<td>${student.studentCode}</td>" +
                            "<td>${student.collegeName}</td>" +
                            "<td>${student.studentName}</td>" +
                            "<td>${student.studentSex}</td>" +
                            "<td>大学${studentRank}年级/${student.enrollTime}年</td>" +
                            "<td>${student.className}</td>" +
                            "<td>${student.telephone}</td>" +
                            "<td class=\"body_function\"><button onclick=\"editInfo(this,\'studentInfo\')\">修改信息</button></td>\n" +
                            "<td class=\"body_function\"><button>发起转学</button></td>\n" +
                            "<td class=\"body_function\"><button onclick=\"riskOperation(\'resetPassword\',this)\">重设密码</button></td>\n" +
                            "<td class=\"body_function\"><button onclick=\"riskOperation(\'student_delete\',this)\">删除</button></td>\n" +
                            "</tr>"

                }

//                println(tableString)

                resp?.writer?.apply {
                    print(tableString)
                    flush()
                    return
                }
            }

        }

        resp?.writer?.apply {
            print("401")
            flush()
            return
        }

    }

    private fun getClassTable(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var classInfoString = ""

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterBelongID = it.getParameter("posterBelongID")

                val classList = ClassDAO().authFilterQuery(posterBelongID, "")
                val collegeList = CollegeDAO().authFilterQuery(posterBelongID, "")

                for (classItem in classList) {

                    classInfoString += "<tr>"

                    classInfoString += "<td>${classItem.classCode}</td>" +
                            "<td>${classItem.className}</td>"

                    for (collegeItem in collegeList) {
                        if (collegeItem.collegeCode in classItem.classCode) {
                            classInfoString += "<td>${collegeItem.collegeName}</td>"
                        }
                    }

                    val classStudentCount = StudentDAO().filterCount("CLASS", classItem.classCode)

                    classInfoString += "<td>${classItem.specialtyName}</td>" +
                            "<td>${classItem.classStartTime}</td>" +
                            "<td>$classStudentCount</td>" +
                            "<td class=\"body_function\">" +
                            "<button onclick=\"riskOperation(\'class_delete\',this)\">删除</button>" +
                            "</td>"

                    classInfoString += "</tr>"

                }

                resp?.writer?.apply {

                    print(classInfoString)
                    flush()
                    return

                }


            }
        }

        resp?.writer?.apply {

            print("401")
            flush()
            return

        }

    }

    private fun getSpecTable(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterBelongID = it.getParameter("posterBelongID")
                var specInfoString = ""

                val specialityList = SpecialityDAO().authFilterQuery(posterBelongID, "")

                for (specItem in specialityList) {

                    specInfoString += "<tr>" +
                            "<td>${specItem.specialityCode}</td>" +
                            "<td>${specItem.specialityName}</td>" +
                            "<td>${specItem.collegeCode}</td>"

                    val specClassCount = ClassDAO().filterCount("SPECIALITY", specItem.specialityCode)
                    specInfoString += "<td>${specClassCount}</td>"

                    val specStudentCount = StudentDAO().filterCount("SPECIALITY", specItem.specialityCode)
                    specInfoString += "<td>${specStudentCount}</td>"


                    specInfoString += "<td class=\"body_function\">" +
                            "<button onclick=\"riskOperation(\'spec_delete\',this)\">删除</button>" +
                            "</td>"
                }


                resp?.writer?.apply {

                    print(specInfoString)
                    flush()
                    return

                }

            }
        }

        resp?.writer?.apply {
            print("401")
            flush()
            return
        }

    }

    private fun getCollegeTable(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterBelongID = it.getParameter("posterBelongID")
                var collegeInfoString = ""

                val collegeList = CollegeDAO().authFilterQuery(posterBelongID, "")

                for (collegeItem in collegeList) {

                    if (collegeItem.collegeCode != "52200") {

                        collegeInfoString += "<tr>"

                        collegeInfoString += "<td>${collegeItem.collegeCode}</td>" +
                                "<td>${collegeItem.collegeName}</td>"

                        val collegeSpecCount = SpecialityDAO().filterCount("", collegeItem.collegeCode)
                        collegeInfoString += "<td>${collegeSpecCount}</td>"

                        val collegeStudentCount = StudentDAO().filterCount("COLLEGE", collegeItem.collegeCode)
                        collegeInfoString += "<td>$collegeStudentCount</td>"

                        collegeInfoString += "</tr>"

                    }
                }

                resp?.writer?.apply {

                    print(collegeInfoString)
                    flush()
                    return

                }

            }
        }

        resp?.writer?.apply {

            print("401")
            flush()
            return

        }

    }


    private fun getStudentEditItem(req: HttpServletRequest?, resp: HttpServletResponse?) {

//        println("Editing")

        var editString = ""

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {
                val editInfoKey = it.getParameter("infoKey").toString()

                val studentInfo = StudentDAO().exactQuery(editInfoKey)

//                print(studentInfo?.studentName)

                studentInfo?.let { stu ->

                    val classList = ClassDAO().editSelectorQuery(studentInfo)

                    editString += "<tr class=\"body_tr\">" +
                            "<td>${stu.studentCode}</td>" +
                            "<td>${stu.collegeName}</td>" +
                            "<td><input class=\"body_input_short\" type=\"text\" value=\"${stu.studentName}\"></td>" +
                            "<td><select name=\"infoItem_sex\">"

                    editString += if (stu.studentSex == "男") {
                        "<option value=\"男\" selected=\"selected\">男</option>\n" +
                                "\t<option value=\"女\">女</option></select></td>"
                    } else {
                        "<option value=\"男\">男</option>\n" +
                                "\t<option value=\"女\" selected=\"selected\">女</option></select></td>"
                    }

                    val currentYear = Year.now().value
                    val studentRank = currentYear - stu.enrollTime.toInt()

                    editString += "<td>大学${studentRank}年级/${currentYear}年</td>"

                    editString += "<td>" +
                            "<select name=\"infoItem_class\">"

                    for (classItem in classList) {

                        editString += if (classItem.classCode == stu.classCode) {
                            "<option value=\"${classItem.classCode}\" selected=\"selected\">${classItem.className}</option>"
                        } else {
                            "<option value=\"${classItem.classCode}\">${classItem.className}</option>"
                        }
                    }

                    editString += "</select></td>"

                    editString += "<td><input class=\"body_input_long\" type=\"number\" value=\"${stu.telephone}\"></td>"



                    editString += "<td class=\"body_function\"><button onclick=\"updateEdit(this,\'student\')\">保存信息</button></td>\n"
                    "</tr>"
                }
                resp?.writer?.apply {

                    print(editString)
                    flush()
                    return

                }
            }


        }

        resp?.writer?.apply {

            print("404")
            flush()
            return

        }

    }

    private fun updateEditItem(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

            if (authSessionID != null && sessionID == authSessionID) {

                when (it.getParameter("updateType")) {

                    "studentInfo" -> {
                        val updateCode = it.getParameter("updateCode").toString()
                        val updateName = it.getParameter("updateName").toString()
                        val updateSex = it.getParameter("updateSex").toString()
                        val classCode = it.getParameter("classCode").toString()
                        val className = it.getParameter("className").toString()
                        val telephone = it.getParameter("telephone").toString()

                        val updateResult =
                            StudentDAO().normalUpdate(
                                updateCode,
                                updateName,
                                updateSex,
                                classCode,
                                className,
                                telephone
                            )


                        if (updateResult) {
                            resp?.writer?.apply {
                                print("SUCCESS")
                                flush()
                                return
                            }
                        } else {
                            resp?.writer?.apply {
                                print("ERROR")
                                flush()
                                return
                            }
                        }
                    }

                    "ventureInfo" -> {

                        val ventureCode = it.getParameter("ventureCode")
                        val ventureName = it.getParameter("ventureName")
                        val ventureType = it.getParameter("ventureType")
                        val ventureBelongCollege = it.getParameter("ventureBelongCollege")
                        val ventureBelongSpec = it.getParameter("ventureBelongSpec")
                        val ventureBelongClass = it.getParameter("ventureBelongClass")
                        val ventureStartDate = it.getParameter("ventureStartDate")
                        val ventureEndDate = it.getParameter("ventureEndDate")
                        val ventureDes = it.getParameter("ventureDes")

                        val ventureObject = Venture(
                            ventureCode,
                            ventureName,
                            ventureStartDate,
                            ventureEndDate,
                            ventureBelongCollege,
                            ventureBelongSpec,
                            ventureBelongClass,
                            ventureType,
                            ventureDes,
                            ""
                        )

                        if (VentureDAO().update(ventureObject)) {
                            resp?.writer?.apply {
                                print("SUCCESS")
                                flush()
                                return
                            }
                        } else {
                            resp?.writer?.apply {
                                print("ERROR")
                                flush()
                                return
                            }
                        }

                    }

                }
            }

        }
    }

    private fun getSaveRequestInfo(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var infoString = ""

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

            if (authSessionID != null && sessionID == authSessionID) {

                val posterToken = it.getParameter("posterBelongID").toString()

                var requestDAO: DaoStructMethod<*>? = null

                val specAndClassFilter = if (it.getParameter("saveRequestFilter") != null) {
                    it.getParameter("saveRequestFilter").toString()
                } else {
                    ""
                }

                when (it.getParameter("saveRequestType")) {
                    "college" -> {
                        requestDAO = CollegeDAO()

                    }

                    "spec" -> {
                        requestDAO = SpecialityDAO()
                    }

                    "class" -> {
                        requestDAO = ClassDAO()
                    }
                }



                requestDAO?.authFilterQuery(posterToken, specAndClassFilter).let { mutList ->

                    mutList?.forEach { item ->

                        when (item) {
                            is College -> {

                                infoString +=
                                    "<option value=\"${item.collegeCode}\">" +
                                            item.collegeName +
                                            "</option>"

                            }

                            is Speciality -> {

                                infoString +=
                                    "<option value=\"${item.specialityCode}\">" +
                                            item.specialityName +
                                            "</option>"

                            }

                            is Class -> {

                                infoString +=
                                    "<option value=\"${item.classCode}\">" +
                                            item.className +
                                            "</option>"

                            }
                        }

                    }

                }

                if (requestDAO == null) {

                    var lastYear = (Year.now().toString().toInt()) - 3

                    repeat(4) {

                        infoString += "<option value=\'$lastYear\'>$lastYear</option>"
                        lastYear++

                    }
                }

                resp?.writer?.apply {

                    print(infoString)
                    flush()
                    return

                }


            }

        }

        resp?.writer?.apply {

            print("401")
            flush()
            return

        }


    }


    private fun deleteInfo(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req?.let {

            val authSessionID = it.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterID = it.getParameter("posterID")
                val password = it.getParameter("riskToken")

                val posterObject = PosterDAO().exactQuery(posterID)

                if (posterObject != null && posterObject.password == password) {

                    when (it.getParameter("riskDataList[riskTarget]")) {
                        "student" -> {
                            val studentCode = it.getParameter("riskDataList[riskCode]")

                            StudentDAO().delete(studentCode)

                            resp?.writer?.apply {
                                print(studentCode)
                                flush()
                                return
                            }
                        }

                        "venture" -> {
                            val ventureCode = it.getParameter("riskDataList[riskCode]")

                            VentureDAO().delete(ventureCode)

                            resp?.writer?.apply {
                                print(ventureCode)
                                flush()
                                return
                            }
                        }

                        "class" -> {
                            val classCode = it.getParameter("riskDataList[riskCode]")

                            ClassDAO().delete(classCode)

                            resp?.writer?.apply {
                                print(classCode)
                                flush()
                                return
                            }
                        }

                        "spec" -> {
                            val specCode = it.getParameter("riskDataList[riskCode]")

                            SpecialityDAO().delete(specCode)

                            resp?.writer?.apply {
                                print(specCode)
                                flush()
                                return
                            }
                        }
                    }

                } else {
                    resp?.writer?.apply {
                        print("401")
                        flush()
                        return
                    }
                }
            }
        }
    }

    private fun reSetUserPassword(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = it.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {
                val userID = it.getParameter("riskDataList[userID]")
                val originPassword = it.getParameter("riskDataList[originPassword]")
                val changedPassword = it.getParameter("riskDataList[changedPassword]")

                val posterDAO = PosterDAO()
                val studentDAO = StudentDAO()

                val posterObject = posterDAO.exactQuery(userID)
                val studentObject = studentDAO.exactQuery(userID)

                if (posterObject != null) {

                    if (posterObject.password == originPassword) {
                        posterDAO.reSetPassword(posterObject.posterCode, changedPassword)
                        posterDAO.setCookie(posterObject)
                        resp?.writer?.apply {
                            print(changedPassword)
                            flush()
                            it.session.invalidate()
                            return
                        }
                    }

                } else if (studentObject != null) {

                    if (studentObject.password == originPassword) {
                        studentDAO.reSetPassword(studentObject.studentCode, changedPassword)
                        studentDAO.setCookie(studentObject)
                        resp?.writer?.apply {
                            print(changedPassword)
                            flush()
                            it.session.invalidate()
                            return
                        }
                    }

                } else {
                    resp?.writer?.apply {
                        print("404")
                        flush()
                        return
                    }
                }

            }

        }

        resp?.writer?.apply {
            print("401")
            flush()
            return
        }

    }

    private fun resetStudentPassword(req: HttpServletRequest?, resp: HttpServletResponse?) {

        //DEBUG LOG
//        print("ResetPassword")

        req?.let {

            val authSessionID = it.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterID = it.getParameter("posterID")
                val password = it.getParameter("riskToken")

                val posterObject = PosterDAO().exactQuery(posterID)

                if (posterObject != null && posterObject.password == password) {

                    when (it.getParameter("riskDataList[riskTarget]")) {
                        "student" -> {

                            val studentCode = it.getParameter("riskDataList[riskCode]")
                            val newPassword = StudentDAO().reSetPassword(studentCode, null)

                            resp?.writer?.apply {
                                print(newPassword)
                                flush()
                                return
                            }
                        }

                        else -> {
                            resp?.writer?.apply {
                                print("404")
                                flush()
                                return
                            }
                        }
                    }
                } else {
                    resp?.writer?.apply {
                        print("401")
                        flush()
                        return
                    }
                }
            }


        }

    }

    private fun getVentureTable(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req?.let {

            val authSessionID = it.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            var ventureTableString = ""

            if (authSessionID != null && sessionID == authSessionID) {


                val posterID = it.getParameter("posterBelongID")
                val filterString = it.getParameter("filter")

                val ventureDAO = VentureDAO()
                val ventureList = ventureDAO.authFilterQuery(posterID, filterString)

                for (venture in ventureList) {

                    ventureTableString += "<tr>" +
                            "<td>${venture.ventureCode}</td>" +
                            "<td>${venture.ventureName}</td>" +
                            "<td>${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}</td>" +
                            "<td colspan=\"3\">${venture.ventureStartDate}->${venture.ventureEndDate}</td>" +
                            "<td class=\"body_function\"><button onclick=\"editInfo(this,\'ventureInfo\')\">详情信息</button></td>" +
                            "<td class=\"body_function\"><button onclick=\"riskOperation(\'venture_delete\',this)\">删除假期</button></td>" +
                            "</tr>"

                }

                resp?.writer?.apply {
                    print(ventureTableString)
                    flush()
                    return
                }

            }

        }
        resp?.writer?.apply {
            print("401")
            flush()
            return
        }
    }

    private fun getEditVenture(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var editString = ""

        req?.let {

            val authSessionID = req.session.id

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())
//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {
                val editInfoKey = it.getParameter("infoKey")

                val venture = VentureDAO().exactQuery(editInfoKey)

                venture?.apply {

                    editString += "$ventureCode&&" +
                            "$ventureName&&" +
                            "$ventureType&&" +
                            "$ventureBelongCollege&&" +
                            "$ventureBelongSpec&&" +
                            "$ventureBelongClass&&" +
                            "$ventureStartDate&&" +
                            "$ventureEndDate&&" + ventureDes

                    resp?.writer?.apply {
                        print(editString)
                        flush()
                        return
                    }

                }


            }

        }

        resp?.writer?.apply {
            print("401")
            flush()
            return
        }

    }

    private fun getVentureCollectList(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var listString = ""

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val posterBelongID = it.getParameter("posterBelongID")
                val ventureDAO = VentureDAO()

                val ventureList = ventureDAO.authFilterQuery(posterBelongID, "")

                for (venture in ventureList) {

                    listString += "${venture.ventureName}-cell-" +
                            "${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}-cell-" +
                            "${venture.ventureStartDate}-cell-" +
                            "${venture.ventureEndDate}-cell-" +
                            venture.ventureCode +
                            "-item-"

                }

                listString = listString.take(listString.length - 6)

                resp?.writer?.apply {
                    if (listString != "") {
                        print(listString)
                    } else {
                        print("404")
                    }
                    flush()
                    return
                }


            }

            resp?.writer!!.apply {
                print("401")
                flush()
                return
            }
        }

    }

    private fun getVentureCollectAndInfo(req: HttpServletRequest?, resp: HttpServletResponse?) {

        val infoAndCollectString = StringBuilder()

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())
//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                val ventureCode = it.getParameter("infoKey")

                val ventureDAO = VentureDAO()
                val studentDAO = StudentDAO()
                val ventureRecordDAO = VentureRecordDAO()

                val ventureObject = ventureDAO.exactQuery(ventureCode)
                val currentDate = LocalDate.now()
                val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

                ventureObject?.apply {
                    infoAndCollectString.apply {
                        append("$ventureCode-cell-")
                        append("$ventureName-cell-")
                        append("$ventureType-cell-")
                        append("$ventureBelongCollege:$ventureBelongSpec:$ventureBelongClass-cell-")
                        append("$ventureStartDate 到 $ventureEndDate-cell-")
                        append("$ventureDes-ventureInfo-")
                    }
                }

                var filterVentureCode = ventureCode.take(ventureCode.length - 6)

                filterVentureCode = if ("00000000" in filterVentureCode) {
                    filterVentureCode.take(filterVentureCode.length - 8)
                } else if ("000000" in filterVentureCode) {
                    filterVentureCode.take(filterVentureCode.length - 6)
                } else if ("0000" in filterVentureCode) {
                    filterVentureCode.take(filterVentureCode.length - 4)
                } else {
                    filterVentureCode
                }

//                println(filterVentureCode)

                val studentList = studentDAO.filterQuery(filterVentureCode)

                if (studentList.size == 0) {
                    resp?.writer?.apply {
                        print("404")
                        flush()
                        return
                    }
                }

                for (student in studentList) {

                    val ventureRecordObject = ventureRecordDAO.exactQuery("$ventureCode ${student.studentCode}")

                    infoAndCollectString.append(
                        if (ventureRecordObject != null) {
                            if (LocalDate.parse(ventureObject?.ventureEndDate, formatter) < currentDate) {
                                "${student.studentCode}-cell-${student.studentName}-cell-${ventureRecordObject.destination}-cell-${ventureRecordObject.ventureDes}-cell-已过期-item-"
                            } else {
                                "${student.studentCode}-cell-${student.studentName}-cell-${ventureRecordObject.destination}-cell-${ventureRecordObject.ventureDes}-cell-已提交-item-"
                            }
                        } else {
                            if (LocalDate.parse(ventureObject?.ventureEndDate, formatter) < currentDate) {
                                "${student.studentCode}-cell-${student.studentName}-cell-无-cell-无-cell-已过期-item-"
                            } else {
                                "${student.studentCode}-cell-${student.studentName}-cell-无-cell-无-cell-未提交-item-"
                            }
                        }
                    )

                }

//                println(infoAndCollectString)

                resp?.writer?.apply {
                    print(infoAndCollectString.toString().take(infoAndCollectString.length - 6))
                    flush()
                    return
                }

            }

            resp?.writer!!.apply {
                print("401")
                flush()
                return
            }


        }

    }

    private fun downloadCollect(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val ventureCode = it.getParameter("ventureCode")
            val workbook: Workbook = createVentureWorkbook(ventureCode)

            resp?.apply {

                contentType = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"
                setHeader("Content-Disposition", "attachment; filename=sample.xlsx")

                workbook.write(outputStream)
                workbook.close()
            }

        }
    }

    private fun createVentureWorkbook(ventureCode: String): Workbook {
        val workbook = XSSFWorkbook()
        val sheet: XSSFSheet = workbook.createSheet("假期去向表单")
        sheet.setColumnWidth(0, 15 * 256)


        val data = mutableListOf(
            arrayOf("学籍号", "学生姓名", "联系电话", "目的地-地址", "其他描述")
        )

        var filterVentureCode = ventureCode.take(ventureCode.length - 6)

        filterVentureCode = if ("00000000" in filterVentureCode) {
            filterVentureCode.take(filterVentureCode.length - 8)
        } else if ("000000" in filterVentureCode) {
            filterVentureCode.take(filterVentureCode.length - 6)
        } else if ("0000" in filterVentureCode) {
            filterVentureCode.take(filterVentureCode.length - 4)
        } else {
            filterVentureCode
        }

        val ventureRecordDAO = VentureRecordDAO()
        val studentList = StudentDAO().filterQuery(filterVentureCode)


        for (student in studentList) {
            val recordObject = ventureRecordDAO.exactQuery("$ventureCode ${student.studentCode}")

            if (recordObject != null) {
                data.add(
                    arrayOf(
                        student.studentCode,
                        student.studentName,
                        student.telephone,
                        recordObject.destination,
                        recordObject.ventureDes
                    )
                )
            } else {
                data.add(
                    arrayOf(student.studentCode, student.studentName, student.telephone, "未填写", "未填写")
                )
            }

        }

        for ((rowNum, row) in data.withIndex()) {
            val excelRow: XSSFRow = sheet.createRow(rowNum)
            for ((cellNum, cellValue) in row.withIndex()) {
                val cell: XSSFCell = excelRow.createCell(cellNum)
                cell.setCellValue(cellValue)
            }
        }

        repeat(5){
            sheet.setColumnWidth(it, 6000)
        }

        return workbook
    }
}



