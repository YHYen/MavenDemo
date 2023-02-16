package com.itYan.service;

import com.itYan.mapper.UserMapper;
import com.itYan.pojo.User;
import com.itYan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * Login Method
     * @param username user account
     * @param password user password
     * @return {@code user} include user data
     */
    public User login(String username, String password) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User user = userMapper.select(username, password);

        sqlSession.close();

        return user;
    }

    /**
     * insert user data into database Method
     * @param user user register data
     */
    public boolean register(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        if (!isUserExists(user)) {
            userMapper.register(user);
            sqlSession.commit();
        }

        sqlSession.close();

        return !isUserExists(user);
    }

    /**
     * find user exists or not Method
     * @param user user data
     * @return {@code user} include user data
     */
    public boolean isUserExists(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        return userMapper.selectByUsername(user.getUsername()) != null;
    }
}
