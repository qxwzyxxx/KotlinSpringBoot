package com.heqing.service

import com.heqing.model.User

interface IUserService{
    fun findById(id: Int): User
    fun findAll():List<User>
    fun insert(user: User)
}