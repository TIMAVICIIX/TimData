package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.ReadyAttendDAO
import com.svh.studentventures_hub.dao_party.dao_model.base.DaoTools
import com.svh.studentventures_hub.dao_party.object_model.info.ReadyAttend
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.time.Year

@WebServlet(name = "AttendController", value = ["/attend-controller"])
class AttendController : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        if (req?.getParameter("stuAddName") == ""){
            resp?.sendRedirect("attend/student_attend.jsp?alertMessage=无效的会话")
            return
        }
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        req?.let {

            if (it.getParameter("stuAddName") == ""){
                resp?.sendRedirect("attend/student_attend.jsp?alertMessage=无效的会话")
                return
            }

            val siteKey = it.getParameter("g-recaptcha-response")

            if (DaoTools.verifyCaptcha(siteKey)) {

                val readyCode = DaoTools.generateUserCode()
                val stuAddName = it.getParameter("stuAddName")
                val stuAddSex = it.getParameter("stuAddSex")
                val stuAddCollege = it.getParameter("stuAddCollege")
                val stuAddSpec = it.getParameter("stuAddSpec")
                val stuAddClass = it.getParameter("stuAddClass")
                val stuAddTelephone = it.getParameter("stuAddTelephone")
                val readyPassword = DaoTools.generateUserCode()

                val readyAttendObject = ReadyAttend(
                    readyCode,
                    stuAddName,
                    stuAddSex,
                    Year.now().value.toString(),
                    stuAddCollege,
                    stuAddSpec,
                    stuAddClass,
                    stuAddTelephone,
                    "待入学",
                    readyPassword
                )

                ReadyAttendDAO().save(readyAttendObject)
                it.session.setAttribute("ReadyCode", readyCode)
                it.session.setAttribute("ReadyPassword", readyPassword)
                it.getRequestDispatcher("/attend/attend_success.jsp").forward(req, resp)
                return


            } else {
                resp?.sendRedirect("attend/student_attend.jsp?alertMessage=验证失败")
            }

            resp?.sendRedirect("attend/student_attend.jsp?alertMessage=无效的会话")

        }
    }

}