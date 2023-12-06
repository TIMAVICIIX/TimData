package com.svh.studentventures_hub.servlet_controller

import com.svh.studentventures_hub.dao_party.dao_model.PosterDAO
import com.svh.studentventures_hub.dao_party.dao_model.VentureDAO
import com.svh.studentventures_hub.dao_party.object_model.info.Poster
import com.svh.studentventures_hub.dao_party.object_model.venture.Venture
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse


@WebServlet(name = "IndexController", value = ["/index-controller"])
class IndexController : HttpServlet() {

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp?.contentType = "text/html;charset=UTF-8"

        when (req?.getParameter("action")) {
            "attend_query" -> getTable(req, resp)
            "login_test" -> loginTest(req, resp)
            "login" -> getLogin(req, resp)
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
                    "<td>${venture.ventureBelong}</td>" +
                    "<td>${venture.ventureDes}</td>" +
                    "<td>${venture.ventureStartDate}</td>" +
                    "<td>${venture.ventureEndDate}</td>" +
                    "<td>${venture.ventureCode.substring(0, 4)}</td>" +
                    "<td>${venture.ventureState}</td>" +
                    "</tr>"

        }

        resp?.writer?.let {
            it.print(tableString)
            it.flush()
        }

    }

    private fun loginTest(req: HttpServletRequest?, resp: HttpServletResponse?) {

        var account: String = ""
        var password: String = ""
        var checkPoster: Poster? = null

        req?.let {
            account = it.getParameter("login_account")
            password = it.getParameter("login_password")
//            print("\n$account\n$password\n")
        }

        checkPoster = PosterDAO().exactQuery(account)

        if (checkPoster == null) {
            resp?.writer?.let {
                it.print("404")
                it.flush()
                return
            }
        } else if (checkPoster.password != password) {
            resp?.writer?.let {
                it.print("401")
                it.flush()
                return
            }
        }

        resp?.writer?.let {
            it.print("100")
            it.flush()
            return
        }

    }

    private fun getLogin(req: HttpServletRequest?, resp: HttpServletResponse?) {

        resp?.writer?.print("SUCCESS!")

    }


}