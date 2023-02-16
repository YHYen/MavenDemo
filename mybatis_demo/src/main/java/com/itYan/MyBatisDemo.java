package com.itYan;

import com.itYan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/*
*  MyBatis introduce
* */
public class MyBatisDemo {
    public static void main(String[] args) throws Exception {
        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. execute sql query
        List<User> users = sqlSession.selectList("test.selectAll");

        System.out.println(users);

        //4. release resource
        sqlSession.close();
    }
}
