package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.VentureDAO
import com.svh.studentventures_hub.dao_party.dao_model.VentureRecordDAO
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoTools.Companion.toStringOrBlank
import com.svh.studentventures_hub.dao_party.object_model.venture.VentureRecord
import com.svh.studentventures_hub.listener.SessionManager
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "StudentHomeController", value = ["/student_home-controller"])
class StudentHomController : HttpServlet() {


    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

        when (req?.getParameter("action")) {
            "query" -> queryBus(req, resp)
            "save" -> saveBus(req, resp)
            "update" -> updateBus(req, resp)
        }
    }

    private fun queryBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                when (it.getParameter("queryType")) {
                    "ventureList" -> {
                        val classCode = it.getParameter("classCode")
                        val studentCode = it.getParameter("studentCode")

                        var ventureListString = ""

                        val ventureDAO = VentureDAO()

                        val ventureList = ventureDAO.stuFilterGetVentures(classCode, "LIMIT_DATE")
                        val stuRecordString = VentureRecordDAO().getStuRecordString(studentCode)

                        for (venture in ventureList) {

                            if (venture.ventureCode !in stuRecordString) {

                                ventureListString += "${venture.ventureName}-cell-" +
                                        "${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}-cell-" +
                                        "${venture.ventureStartDate}-cell-" +
                                        "${venture.ventureEndDate}-cell-" +
                                        venture.ventureCode +
                                        "-item-"
                            }

                        }

                        ventureListString = ventureListString.take(ventureListString.length - 6)


                        resp?.writer?.apply {
                            if (ventureListString != "") {
                                print(ventureListString)
                            } else {
                                print("404")
                            }
                            flush()
                            return
                        }

                    }

                    "ventureItem" -> {
                        val itemVentureCode = it.getParameter("queryAttendInfo[ventureCode]")

                        VentureDAO().exactQuery(itemVentureCode)?.apply {
                            resp?.writer?.apply {
                                print(
                                    "$ventureCode&&$ventureName&&$ventureType&&$ventureBelongCollege:$ventureBelongSpec:$ventureBelongClass" +
                                            "&&${ventureStartDate} 到 ${ventureEndDate}&&$ventureDes"
                                )
                                flush()
                                return
                            }
                        }

                        resp?.writer?.apply {
                            print("404")
                            flush()
                            return
                        }


                    }

                    "historyVentureList" -> {
                        val classCode = it.getParameter("classCode")
                        val studentCode = it.getParameter("studentCode")

                        var ventureListString = ""

                        val ventureDAO = VentureDAO()

                        val ventureList = ventureDAO.stuFilterGetVentures(classCode, "LIMITLESS_DATE")
                        val stuRecordString = VentureRecordDAO().getStuRecordString(studentCode)

                        for (venture in ventureList) {

                            if (venture.ventureCode in stuRecordString) {
                                ventureListString += "${venture.ventureName}-cell-" +
                                        "${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}-cell-" +
                                        "${venture.ventureStartDate}-cell-" +
                                        "${venture.ventureEndDate}-cell-" +
                                        "${venture.ventureCode}-cell-" +
                                        venture.ventureState +
                                        "-item-"
                            } else {
                                if (venture.ventureState == "已过期") {
                                    ventureListString += "${venture.ventureName}-cell-" +
                                            "${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}-cell-" +
                                            "${venture.ventureStartDate}-cell-" +
                                            "${venture.ventureEndDate}-cell-" +
                                            "${venture.ventureCode}-cell-" +
                                            venture.ventureState +
                                            "-item-"
                                }
                            }

                        }

                        ventureListString = ventureListString.take(ventureListString.length - 6)


                        resp?.writer?.apply {
                            if (ventureListString != "") {
                                print(ventureListString)
                            } else {
                                print("404")
                            }
                            flush()
                            return
                        }

                    }

                    "historyVentureItem" -> {
                        val itemVentureCode = it.getParameter("queryAttendInfo[ventureCode]")
                        val itemStudentCode = it.getParameter("studentCode")

                        val ventureObject = VentureDAO().exactQuery(itemVentureCode)
                        val ventureRecordObject = VentureRecordDAO().exactQuery("$itemVentureCode $itemStudentCode")


                        ventureObject?.apply {
                            resp?.writer?.apply {
                                print(
                                    "$ventureCode&&$ventureName&&$ventureType&&$ventureBelongCollege:$ventureBelongSpec:$ventureBelongClass" +
                                            "&&${ventureStartDate} 到 ${ventureEndDate}&&$ventureDes" +
                                            "&&${ventureRecordObject?.destination}&&${ventureRecordObject?.ventureDes}"
                                )
                                flush()
                                return
                            }
                        }

                        resp?.writer?.apply {
                            print("404")
                            flush()
                            return
                        }

                    }


                }
            }

            resp?.writer!!.apply {
                print("401")
                flush()
                return
            }

        }

    }

    private fun saveBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())
//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                when (it.getParameter("saveDataList[saveType]")) {

                    "ventureForm" -> {

                        val ventureCode = it.getParameter("saveDataList[ventureCode]")
                        val studentCode = it.getParameter("saveDataList[studentCode]")

                        val ventureName = it.getParameter("saveDataList[ventureName]")
                        val studentName = it.getParameter("saveDataList[studentName]")

                        val ventureTarget = it.getParameter("saveDataList[ventureTarget]")
                        val ventureOtherDes = it.getParameter("saveDataList[ventureOtherDes]")

                        val ventureRecordObject = VentureRecord(
                            studentCode,
                            ventureCode,
                            ventureName,
                            studentName,
                            ventureTarget,
                            ventureOtherDes
                        )


                        resp?.writer?.apply {

                            if (VentureRecordDAO().save(ventureRecordObject)) {
                                print("500")
                            } else {
                                print("401")
                            }

                            flush()
                            return
                        }

                    }

                }

            }

            resp?.writer!!.apply {
                print("401")
                flush()
                return
            }

        }

    }

    private fun updateBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            val authSessionID = req.getParameter("Authorization")

            val sessionID = SessionManager.getSessionID(it.session.getAttribute("userID").toStringOrBlank())

//            println("authSessionID:$authSessionID\nsessionID:$sessionID")

            if (authSessionID != null && sessionID == authSessionID) {

                when (it.getParameter("updateDataList[updateType]")) {

                    "ventureForm" -> {

                        val studentCode = it.getParameter("updateDataList[studentCode]")
                        val ventureCode = it.getParameter("updateDataList[ventureCode]")

                        val ventureTarget = it.getParameter("updateDataList[ventureTarget]")
                        val ventureDes = it.getParameter("updateDataList[ventureOtherDes]")

                        val ventureRecordDAO = VentureRecordDAO()
                        val originVentureRecord = ventureRecordDAO.exactQuery("$ventureCode $studentCode")

                        val targetVentureRecord = VentureRecord(
                            studentCode,
                            ventureCode,
                            originVentureRecord!!.ventureName,
                            originVentureRecord.studentName,
                            ventureTarget,
                            ventureDes
                        )

                        resp?.writer?.apply {

                            if (ventureRecordDAO.update(targetVentureRecord)) {
                                print("500")
                            } else {
                                print("404")
                            }
                            flush()
                            return
                        }


                    }

                }
            }

            resp?.writer!!.apply {
                print("401")
                flush()
                return
            }


        }

    }

}