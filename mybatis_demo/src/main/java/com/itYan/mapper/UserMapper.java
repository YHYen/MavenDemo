package com.itYan.mapper;

import com.itYan.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {

    List<User> selectAll();

    @Select("SELECT * FROM tb_user WHERE id = #{id}")
    User userSelectById(int id);
}
