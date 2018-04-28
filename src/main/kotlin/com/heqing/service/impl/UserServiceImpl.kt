package com.heqing.service.impl

import com.heqing.model.User
import com.heqing.dao.UserRepository
import com.heqing.service.IUserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : IUserService {


    @Autowired
    lateinit var userRepository: UserRepository

    override fun findById(id: Int): User {
        return userRepository.findById(id)
    }

    override fun findAll(): List<User> {
        return userRepository.findAll()
    }

    override fun insert(user: User) {
        userRepository.insert(user)
    }
}