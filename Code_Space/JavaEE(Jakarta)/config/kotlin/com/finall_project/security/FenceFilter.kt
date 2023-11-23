package com.finall_project.security

import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpSession

@WebFilter(filterName = "FenceFilter" , urlPatterns = ["/*"])
class FenceFilter:Filter {

    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {
        val httpRequest = p0 as HttpServletRequest
        val httpResponse = p1 as HttpServletResponse

        val loginSession:HttpSession? = httpRequest.session
        val user = loginSession?.getAttribute("user")

        if(user != null){
            //TODO(sendReDirection)
        }else{
            httpResponse.sendRedirect("/index.jsp")
        }

    }

}