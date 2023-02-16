package com.itYan.test;

import com.itYan.mapper.UserMapper;
import com.itYan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserMapperTest {
    @Test
    public void testUserSelectById() throws IOException {
        //0. get variable id
        int id = 1;

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        //4. execute sql query function
        User user = userMapper.userSelectById(id);
        System.out.println(user);

        //5. release resource
        sqlSession.close();

    }
}
