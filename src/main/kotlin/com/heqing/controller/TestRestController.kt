package com.heqing.controller

import com.heqing.dao.UserRepository
import com.heqing.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController{
    @Autowired
    lateinit  var userServiceImpl: UserServiceImpl

    @GetMapping("/allUser")
    fun hello():Any{
        val users=userServiceImpl.findAll()
        return users
    }

    @GetMapping("/id={id}")
    fun getUser(@PathVariable id:Int):Any{
        var user=userServiceImpl.findById(id)
        return  user
    }
}