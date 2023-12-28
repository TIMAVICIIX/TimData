package com.svh.studentventures_hub.dao_party.dao_model.base

import java.io.BufferedReader
import java.io.DataOutputStream
import java.io.InputStreamReader
import java.io.StringReader
import java.lang.reflect.Field
import java.net.URL
import java.sql.ResultSet
import javax.json.Json
import javax.json.JsonObject
import javax.net.ssl.HttpsURLConnection
import kotlin.random.Random

class DaoTools {

    companion object {


        inline fun <reified T : Any> ResultSet.getEntityList(): MutableList<T> {
            val resultList = mutableListOf<T>()
            while (this.next()) {
                val entity = resultSetToEntity<T>(this)
                resultList.add(entity)
            }
            return resultList
        }

        inline fun <reified T : Any> resultSetToEntity(resultSet: ResultSet): T {

            val entity = T::class.java.getDeclaredConstructor().newInstance()
            val metaData = resultSet.metaData
            for (i in 1..metaData.columnCount) {
                val columnName = metaData.getColumnName(i)
                val columnValue = resultSet.getObject(i)

                val field: Field? = try {
                    T::class.java.getDeclaredField(columnName)
                } catch (e: NoSuchFieldException) {
                    null
                }

                field?.let {
                    it.isAccessible = true
                    it.set(entity, columnValue)
                }
            }
            return entity
        }

        fun Any?.toStringOrBlank(): String {
            return this?.toString() ?: " "
        }

        fun generateUserCode():String{

            val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')
            val random = Random.Default
            return (1..10)
                .map { random.nextInt(0, charPool.size) }
                .map(charPool::get)
                .joinToString("")
        }

        fun verifyCaptcha(gRecaptchaResponse: String?): Boolean {

            val url = "https://recaptcha.net/recaptcha/api/siteverify"
            val secret = "6Lc5gj4pAAAAAI-StpRncuV3t4mBUPJ9U_Xy9rkq"
            val userAgent = "Mozilla/5.0"

            if (gRecaptchaResponse == null || gRecaptchaResponse == "") {
                return false
            }

            try {

                val urlObject = URL(url)
                val httpConn = urlObject.openConnection() as HttpsURLConnection

                httpConn.requestMethod = "POST"
                httpConn.setRequestProperty("User-Agent", userAgent)
                httpConn.setRequestProperty("Accept-Language", "en-US,en;q=0.5")

                val postParams = "secret=$secret&response=$gRecaptchaResponse"

                httpConn.doOutput = true
                DataOutputStream(httpConn.outputStream).use {
                    it.writeBytes(postParams)
                    it.flush()
                }

                BufferedReader(InputStreamReader(httpConn.inputStream)).use {buf->
                    var inputLine: String?
                    val response = StringBuffer()

                    while (buf.readLine().also { inputLine = it } != null) {
                        response.append(inputLine)
                    }


                    println(response.toString())

                    Json.createReader(StringReader(response.toString())).use {
                        val jsonObject: JsonObject = it.readObject()

                        return  jsonObject.getBoolean("success")
                    }


                }

            }catch (e:Exception){
                e.printStackTrace()
                return false
            }

        }

    }

}