package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.ClassDAO
import com.svh.studentventures_hub.dao_party.dao_model.CollegeDAO
import com.svh.studentventures_hub.dao_party.dao_model.SpecialityDAO
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoStructMethod
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoTools.Companion.toStringOrBlank
import com.svh.studentventures_hub.dao_party.object_model.info.Class
import com.svh.studentventures_hub.dao_party.object_model.info.College
import com.svh.studentventures_hub.dao_party.object_model.info.Speciality
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


@WebServlet(name = "AttendRequestController", value = ["/attend_request-controller"])
class AttendRequestController : HttpServlet() {

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        when (req?.getParameter("action")) {
            "saveRequest" -> requestBus(req, resp)
        }
    }

    private fun requestBus(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var identityToken = ""
        var requestDAO: DaoStructMethod<*>? = null
        var infoString = ""

        when (req?.getParameter("saveRequestType")) {
            "college" -> {
                requestDAO = CollegeDAO()
            }

            "spec" -> {
                requestDAO = SpecialityDAO()
                identityToken = req.getParameter("saveRequestFilter").toStringOrBlank()
            }

            "class" -> {
                requestDAO = ClassDAO()
                identityToken = req.getParameter("saveRequestFilter").toStringOrBlank()
            }
        }
        requestDAO?.authFilterQuery("52200", identityToken).let { mutList ->

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
        resp?.writer?.apply {

            print(infoString)
            flush()
            return

        }
    }

}