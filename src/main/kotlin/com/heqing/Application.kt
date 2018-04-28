package com.heqing

import com.fasterxml.jackson.databind.ObjectMapper
import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.servlet.view.json.MappingJackson2JsonView
import java.sql.DriverManager

@MapperScan("com.heqing.dao")
@SpringBootApplication
open class Application {

    @Bean
    open fun json(): MappingJackson2JsonView {
        return MappingJackson2JsonView(ObjectMapper())
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}


fun onCreateDB(){
    //连接SQLite的JDBC
    Class.forName("org.sqlite.JDBC")
    //建立一个数据库名example.db的连接，如果不存在就在当前目录下创建之
    val conn = DriverManager.getConnection("jdbc:sqlite:src/main/resources/kotlin_test.db")
    val stat = conn.createStatement() // //创建一个表,包含id、name两个字段
    stat.executeUpdate("create table user(id int,name varchar(20));")
    // 插入一行数据
    stat.executeUpdate("insert into user values(1,'Wiki1');")
    stat.executeUpdate("insert into user values(2,'Wiki2');")
    //查询所有数据
    val rs = stat.executeQuery("select * from user;")
    while (rs.next()) {
        //将查询到的数据打印出来
        print("id = " + rs.getString("id") + " ")
        println("name = " + rs.getString("name"))
    }
    rs.close()
    conn.close()
}


