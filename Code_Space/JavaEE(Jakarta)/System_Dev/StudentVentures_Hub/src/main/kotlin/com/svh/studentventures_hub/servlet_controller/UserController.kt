package com.svh.studentventures_hub.servlet_controller

import jakarta.servlet.annotation.MultipartConfig
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File

@WebServlet(name = "UserController", value = ["/user-controller"])
@MultipartConfig
class UserController : HttpServlet() {
    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {
        changeIcon(req, resp)
    }

    private fun changeIcon(req: HttpServletRequest?, resp: HttpServletResponse?) {
        println("CHANGE ICON")
        req?.let {


            val userID = it.session.getAttribute("userID")

            if (userID != "") {

                val iconFile = it.getPart("iconFile")

                iconFile?.let {

                    val iconName = iconFile.name

                    println(iconName)

                    val savePath =
                        "D:\\Git_Space\\Code_Space\\JavaEE(Jakarta)\\System_Dev\\User's_Avatar"

                    deleteExistingFile("$savePath\\$userID.png")

                    try {
                        val realSavePath = "$savePath\\$userID.png"
                        iconFile.write(realSavePath)
                    } catch (e: Exception) {
                        resp?.writer?.apply {
                            print("500")
                            flush()
                            return
                        }
                    }

                    resp?.writer!!.apply {
                        print("200")
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

    private fun deleteExistingFile(filePath: String) {
        val existingFile = File(filePath)
        if (existingFile.exists()) {
            existingFile.delete()
        }
    }

}