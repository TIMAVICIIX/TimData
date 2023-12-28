package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.CollegeDAO
import com.svh.studentventures_hub.dao_party.dao_model.PosterDAO
import com.svh.studentventures_hub.dao_party.dao_model.StudentDAO
import com.svh.studentventures_hub.dao_party.dao_model.VentureDAO
import com.svh.studentventures_hub.dao_party.object_model.info.Poster
import com.svh.studentventures_hub.dao_party.object_model.info.Student
import com.svh.studentventures_hub.dao_party.object_model.venture.Venture
import com.svh.studentventures_hub.listener.SessionManager
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File
import java.nio.file.Files
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*


@WebServlet(name = "IndexController", value = ["/index-controller"])
class IndexController : HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

//        println("进入GET")

        when (req?.getParameter("action")) {
            null -> authUser(req, resp)
            else -> resp?.sendRedirect("index.jsp")
        }
    }

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

//        println("进入POST")

        when (req?.getParameter("action")) {
            "attend_query" -> getTable(req, resp)
            "login_test" -> loginTest(req, resp)
            "login" -> getLogin(req, resp)
            "stuAndCollegeNum" ->getStuAndCollege(req,resp)
        }

    }

    private fun getTable(req: HttpServletRequest?, resp: HttpServletResponse?) {

        val ventureConn = VentureDAO()

        var tableString = ""

        val venturesList: MutableList<Venture> = if (req?.getParameter("filter").isNullOrEmpty()) {
            ventureConn.completeQuery()
        } else {
            ventureConn.filterQuery(req?.getParameter("filter").toString())
        }

        for (venture in venturesList) {

            tableString += "<tr>" +
                    "<td>${venture.ventureName}</td>" +
                    "<td class=\'small_td_font\'>${venture.ventureBelongCollege}:${venture.ventureBelongSpec}:${venture.ventureBelongClass}</td>" +
                    "<td>${venture.ventureType}</td>" +
                    "<td>${venture.ventureStartDate}</td>" +
                    "<td>${venture.ventureEndDate}</td>" +
                    "<td>${venture.ventureStartDate.substring(0, 4)}</td>" +
                    "<td>${venture.ventureState}</td>" +
                    "</tr>"

        }

        resp?.writer?.let {
            it.print(tableString)
            it.flush()
        }

    }

    private fun loginTest(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var account = ""
        var password = ""

        req?.let {
            account = it.getParameter("login_account")
            password = it.getParameter("login_password")
//            print("\n$account\n$password\n")
        }

        val checkPoster: Poster? = PosterDAO().exactQuery(account)
        val checkStudent: Student? = StudentDAO().exactQuery(account)

        if (checkPoster != null) {

            if (checkPoster.password == password) {
                resp?.writer?.let {
                    it.print("100")
                    it.flush()
                    return
                }
            }

            resp?.writer?.let {
                it.print("401")
                it.flush()
                return
            }

        } else if (checkStudent != null) {
            if (checkStudent.password == password) {
                resp?.writer?.let {
                    it.print("100")
                    it.flush()
                    return
                }
            }
            resp?.writer?.let {
                it.print("401")
                it.flush()
                return
            }
        }

        resp?.writer?.let {
            it.print("404")
            it.flush()
            return
        }

    }

    private fun getLogin(req: HttpServletRequest?, resp: HttpServletResponse?) {

//        println("getLogin")

        var account: String
        var password: String

        req?.let {
            account = it.getParameter("login_account")
            password = it.getParameter("login_password")


            val posterUser: Poster? = PosterDAO().exactQuery(account)
            val studentUser: Student? = StudentDAO().exactQuery(account)

            if (posterUser?.posterCode == account && posterUser.password == password) {
                SessionManager.destroy(posterUser.posterCode)


//                println("Before:${it.session.id}")

                it.session.apply {
                    setAttribute("userID", posterUser.posterCode)
                    setAttribute("userName", posterUser.posterName)

                    if (posterUser.posterCode == "52284000") {
                        setAttribute("userBelong", "全体学院")
                    } else {
                        setAttribute("userBelong", CollegeDAO().exactQuery(posterUser.managerTarget)?.collegeName)
                    }
                    setAttribute("userBelongID", posterUser.managerTarget)
                    setAttribute("userType", "管理员")

                    setAttribute("userIconFile", getIconFile(posterUser.posterCode))

                    maxInactiveInterval = 1800

                    val cookieUDDI = PosterDAO().setCookie(posterUser)

//                    println("ID:${posterUser.posterCode}\nCookieID:$cookieUDDI")

                    val cookie = Cookie("StudentVenture_AuthCookie", cookieUDDI)
                    cookie.maxAge = 60 * 60
                    resp?.addCookie(cookie)

                    SessionManager.associateUserWithSession(posterUser.posterCode, this)
                }

                req.getRequestDispatcher("Page_homePage/poster_home.jsp").forward(req, resp)
//                println("After:${it.session.id}")
                return


            } else if (studentUser != null && studentUser.password == password) {
                SessionManager.destroy(studentUser.studentCode)


                it.session.apply {
                    setAttribute("userID", studentUser.studentCode)
                    setAttribute("userName", studentUser.studentName)
                    setAttribute(
                        "userBelong",
                        studentUser.collegeName
                    )
                    setAttribute("userBelongID", studentUser.classCode)
                    setAttribute("userType", "学生")

                    setAttribute("userIconFile", getIconFile(studentUser.studentCode))
                    setAttribute(
                        "formTask",
                        (VentureDAO().filterCount(studentUser.classCode, studentUser.studentCode)).toString()
                    )

                    maxInactiveInterval = 1800

                    val cookieUDDI = StudentDAO().setCookie(studentUser)

//                    println("ID:${studentUser.studentCode}\nCookieID:$cookieUDDI")

                    val cookie = Cookie("StudentVenture_AuthCookie", cookieUDDI)
                    cookie.maxAge = 60 * 60
                    resp?.addCookie(cookie)

                    SessionManager.associateUserWithSession(studentUser.studentCode, this)

                }

                req.getRequestDispatcher("Page_homePage/student_home.jsp").forward(req, resp)
                return


            }
        }

    }

    private fun authUser(req: HttpServletRequest?, resp: HttpServletResponse?) {

//        println("Authing")

        req?.let {

            it.cookies?.let { cookies ->

                val authPoster = PosterDAO()
                val authStudent = StudentDAO()

                for (cookie in cookies) {

                    if (cookie.name == "StudentVenture_AuthCookie") {

                        val token = cookie.value
                        val posterUser = authPoster.authCookie(token)
                        val studentUser = authStudent.authCookie(token)

                        if (posterUser != null) {
                            SessionManager.destroy(posterUser.posterCode)

                            it.session.apply {
                                setAttribute("userID", posterUser.posterCode)
                                setAttribute("userName", posterUser.posterName)
                                if (posterUser.posterCode == "52284000") {
                                    setAttribute("userBelong", "全体学院")
                                } else {
                                    setAttribute(
                                        "userBelong",
                                        CollegeDAO().exactQuery(posterUser.managerTarget)?.collegeName
                                    )
                                }
                                setAttribute("userBelongID", posterUser.managerTarget)
                                setAttribute("userType", "管理员")

                                setAttribute("userIconFile", getIconFile(posterUser.posterCode))

                                maxInactiveInterval = 1800

                                SessionManager.associateUserWithSession(posterUser.posterCode, this)
//                                println("SessionID:"+it.session.id)

                                req.getRequestDispatcher("/Page_homePage/poster_home.jsp").forward(req, resp)
                                return
                            }

                        } else if (studentUser != null) {
                            SessionManager.destroy(studentUser.studentCode)

                            val currentDate = LocalDate.now()
                            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                            val formattedDate = currentDate.format(formatter)

                            it.session.apply {
                                setAttribute("userID", studentUser.studentCode)
                                setAttribute("userName", studentUser.studentName)
                                setAttribute(
                                    "userBelong",
                                    studentUser.collegeName
                                )
                                setAttribute("userBelongID", studentUser.classCode)
                                setAttribute("userType", "学生")

                                setAttribute("userIconFile", getIconFile(studentUser.studentCode))
                                setAttribute(
                                    "formTask",
                                    (VentureDAO().filterCount(
                                        studentUser.classCode,
                                        studentUser.studentCode
                                    )).toString()
                                )

                                maxInactiveInterval = 1800

                                SessionManager.associateUserWithSession(studentUser.studentCode, this)

                                req.getRequestDispatcher("/Page_homePage/student_home.jsp").forward(req, resp)
                                return
                            }
                        }

                    }
                }
                resp?.sendRedirect("${req.contextPath}/index.jsp")
                return
            }

        }
        resp?.sendRedirect("${req?.contextPath}/index.jsp")
        return

    }

    private fun getStuAndCollege(req: HttpServletRequest?, resp: HttpServletResponse?){

        val stuCount = StudentDAO().getComplexCount()
        val collegeCount = CollegeDAO().getComplexCount()

        resp?.writer?.apply {
            print("$stuCount&&$collegeCount")
            flush()
            return
        }

    }

    private fun getIconFile(posterID: String): String {

        val iconPNGFile = File("D:\\Git_Space\\Code_Space\\JavaEE(Jakarta)\\System_Dev\\User's_Avatar\\${posterID}.png")
        val defaultPNGFile = File("D:\\Git_Space\\Code_Space\\JavaEE(Jakarta)\\System_Dev\\User's_Avatar\\default.png")

        val pngBytes = if (iconPNGFile.exists()) {
            Files.readAllBytes(iconPNGFile.toPath())
        } else {
            Files.readAllBytes(defaultPNGFile.toPath())
        }

        return Base64.getEncoder().encodeToString(pngBytes)
    }


}