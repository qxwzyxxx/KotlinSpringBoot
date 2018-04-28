package com.heqing.controller

import com.heqing.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import javax.servlet.http.HttpServletRequest

@Controller
class TestController{
    @Autowired
    lateinit  var userServiceImpl: UserServiceImpl

    @GetMapping("/index")
    fun index(request:HttpServletRequest):Any{
        val users=userServiceImpl.findAll()
        request.setAttribute("users",users)
        return "/index.jsp"
    }
}