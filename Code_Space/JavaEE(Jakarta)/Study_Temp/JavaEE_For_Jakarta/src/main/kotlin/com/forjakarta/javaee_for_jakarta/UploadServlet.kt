package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.annotation.MultipartConfig
import jakarta.servlet.annotation.WebServlet
import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

@WebServlet(name = "UploadServlet", urlPatterns = ["/UploadServlet"])
@MultipartConfig(fileSizeThreshold = 5242880, maxFileSize = 20971520L, maxRequestSize = 41943040L)
class UploadServlet : HttpServlet() {

    override fun doPost(req: HttpServletRequest?, resp: HttpServletResponse?) {

        req?.let {
            resp?.let {

                val part = req.getPart("uploadFiles")

                val header = part.getHeader("content-disposition")

                val fileName = header.substring(header.indexOf("filename=") + 10, header.length - 1)

                if (fileName == "") {
                    req.getRequestDispatcher("UploadFile.jsp").forward(req, resp)
                }

                val size = part.size
                val inputStream = part.inputStream

                var realPath = req.servletContext.getRealPath("")
                realPath = realPath + File.separator + "uploadFiles"

                val contextPath = req.servletContext.contextPath

                val downFilePath = "$contextPath/uploadFiles/$fileName"

                val file = File(realPath , fileName)
                if (!file.parentFile.exists()) {
                    //Debug
//                    print(realPath + "\n")
//                    println("FosPath:" + realPath + File.separator + fileName)
                    file.mkdirs()
                }

                var fos: FileOutputStream? = null


                try {
                    //Debug

                    fos = FileOutputStream(file)

                    var data = ByteArray(1024)

                    var length = inputStream.read(data)

                    while (length != -1) {
                        fos.write(data, 0, length)
                        length = inputStream.read(data)
                    }

                    req.setAttribute("downloadFilePath", downFilePath)
                    req.getRequestDispatcher("uploadSuccess.jsp").forward(req, resp)

                } catch (e: IOException) {
                    e.printStackTrace()
                    req.getRequestDispatcher("uploadError.jsp").forward(req, resp)
                } finally {

                    fos?.close()
                    inputStream?.close()

                }

            }
        }
    }

}