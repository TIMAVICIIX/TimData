package com.forjakarta.javaee_for_jakarta

import jakarta.jws.soap.InitParam
import jakarta.servlet.Filter
import jakarta.servlet.FilterChain
import jakarta.servlet.ServletRequest
import jakarta.servlet.ServletResponse
import jakarta.servlet.annotation.WebFilter

@WebFilter(filterName = "accessAuth", value = ["/IMG_Data/*"])
class AccessAuth : Filter {

    override fun doFilter(p0: ServletRequest?, p1: ServletResponse?, p2: FilterChain?) {



    }


}