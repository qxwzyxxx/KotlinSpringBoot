package com.heqing.controller

import com.heqing.model.User
import com.heqing.service.impl.UserServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/users")
class TestMappingController {
    @Autowired
    lateinit  var userServiceImpl: UserServiceImpl

    @RequestMapping("/name={name}&password={password}",  method = arrayOf(RequestMethod.GET))
    fun get(@PathVariable name:String,@PathVariable password:String) :Any{
        var user= User()
        user.name=name
        user.password=password
        userServiceImpl!!.insert(user)
        return "User(name=$name,password=$password)"
    }
}