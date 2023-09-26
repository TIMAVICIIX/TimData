package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "LoginServlet",value = ["/loginByServlet"])
class LoginLet: HttpServlet() {

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        val name=req?.getParameter("loginName")
        val pwd=req?.getParameter("pwd")

        if("admin" == name && "123" == pwd){
            resp?.writer?.write("<h1>Welcome:$name</h1>")
        }else{
            resp?.sendRedirect("LoginLet.html")
        }
    }


}