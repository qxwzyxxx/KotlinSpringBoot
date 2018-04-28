package com.heqing.dao


import com.heqing.model.User
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository


@Repository
interface UserRepository{
    @Select("SELECT * FROM User WHERE ID = #{id}")
    fun findById(@Param("id") integer:Int?): User

    @Select("SELECT * FROM User")
    fun findAll():List<User>

    @Insert("INSERT INTO User(name,password) VALUES(#{name},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    fun insert(user: User)
}