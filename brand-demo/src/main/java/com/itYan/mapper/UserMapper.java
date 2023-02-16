package com.itYan.mapper;

import com.itYan.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /*
    * 根據用戶名和密碼查詢用戶對象
    * @Param username: 自網頁輸入的用戶名
    * @Param password: 自網頁輸入的用戶密碼
    * @return
    * */
    @Select("select * from tb_user where username= #{username} and password = #{password}")
    User select(@Param("username") String username, @Param("password") String password);

    @Insert("insert into tb_user values(null, #{username}, #{password}, #{gender}, #{email})")
    void register(User user);

    @Select("select * from tb_user where username = #{username}")
    User selectByUsername(@Param("username") String username);
}
