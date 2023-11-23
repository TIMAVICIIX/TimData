package com.forjakarta.javaee_for_jakarta

import jakarta.servlet.*
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.annotation.WebInitParam
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import java.util.*

@WebFilter(
    urlPatterns = ["/student/*"],
    initParams = [WebInitParam(name = "basePackage", value = "com.forjakarta.javaee_for_jakarta")]
)
class MethodMappingFilter : Filter {

    private var basePackage: String? = null


//    获取Servlet主包
    override fun init(filterConfig: FilterConfig) {
        print("Init Start!")
        basePackage = filterConfig.getInitParameter("basePackage")
//        print(basePackage+"\n")
    }

    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
        val httpRequest = p0 as HttpServletRequest
//        获取Servlet往后的请求路径，不包括斜杠
        val pathInfo = httpRequest.pathInfo
//       获取Servlet请求方法名
        val servletMethodName = p0.servletPath.substringAfterLast("/")

//        组成Servlet本地类路径，后期进行实例化substring去掉斜杠
        val fullClassName = "$basePackage.QADUs"
        print("basePackage:$basePackage\n")
        print(fullClassName+"\n")

        try {


            val servletClass = Class.forName(fullClassName)
//            通过获取该类的构造函数进行类的实例化
//            /**如果Servlet池有该实例就不需要进行实例化**/
            val servletInstance = servletClass.getDeclaredConstructor().newInstance()

//            获取该类中的所有公共方法并进行遍历
            for (method in servletClass.methods) {

                print("Current method:${method.name}\n")

//                获取该方法的MethodMapping注解
                val methodMapping = method.getAnnotation(MethodMapping::class.java)

//                如果该方法有MethodMapping注解，并且方法名称是请求方法名称
                if (methodMapping != null && method.name == servletMethodName) {

//                  直接传出Http响应

                    print("Execute Invoke:\n")
                    print("params:$p0\n")
                    method.invoke(servletInstance, p0)
                    return

                }

            }

        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

}