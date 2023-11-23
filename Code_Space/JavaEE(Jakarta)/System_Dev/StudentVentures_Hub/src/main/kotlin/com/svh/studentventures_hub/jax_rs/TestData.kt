package com.svh.studentventures_hub.jax_rs

import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

@WebServlet(name = "testData", value = ["/get_test"])
class TestData : HttpServlet() {

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let { outIt ->

            val num1 = outIt.getParameter("num1")
            val num2 = outIt.getParameter("num2")

            val sum = num1.toInt() + num2.toInt()

            resp?.writer?.write("num1+num2=${sum}")
        }

    }

}