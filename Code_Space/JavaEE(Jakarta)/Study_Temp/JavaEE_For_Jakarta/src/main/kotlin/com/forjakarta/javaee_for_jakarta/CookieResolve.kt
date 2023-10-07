package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.Cookie
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "cookieResolve", urlPatterns = ["/CookieResolve"])
class CookieResolve : HttpServlet() {

    private val rememberLoginName = "on"
    private val loginName = "admin"
    private val password = "admin"

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        this.doGet(req, resp)
    }

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {

            resp?.let {

                val tempLoginName = req.getParameter("inputName")
                //Debug Log:
                //println(tempLoginName)
                val tempLoginPwd = req.getParameter("inputPwd")
                //Debug Log:
                //println(tempLoginPwd)
                val tempRemember = req.getParameter("isWrite")

                if (loginName == tempLoginName && password == tempLoginPwd) {
                    req.session.setAttribute("user", loginName)

                    if (rememberLoginName == tempRemember) {
                        val cookieName = Cookie("loginName", tempLoginName)
                        val cookiePwd = Cookie("password", tempLoginPwd)

                        resp.addCookie(cookieName)
                        resp.addCookie(cookiePwd)

                    }

                    resp.sendRedirect("welcome.jsp")

                } else {
                    resp.sendRedirect("cookie_login.jsp")
                }

            }
        }

    }


}