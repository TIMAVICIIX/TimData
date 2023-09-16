package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.http.*
import jakarta.servlet.annotation.*

@WebServlet(name = "helloServlet", value = ["/hello-servlet"])
class HelloServlet : HttpServlet() {
    private var message: Int=1

//    override fun init() {
//
//    }

    public override fun doGet(request: HttpServletRequest, response: HttpServletResponse) {
//        response.contentType = "text/html"

        response.sendRedirect("http://localhost:8080/JavaEE_For_Jakarta_war_exploded/ErrorPage.jsp")

        // Hello
//        val out = response.writer
//        out.println("<html><body>")
//        out.println("<h1>${message/0}</h1>")
//        out.println("</body></html>")
    }

    override fun destroy() {
    }
}