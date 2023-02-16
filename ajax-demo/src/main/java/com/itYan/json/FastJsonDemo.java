package com.itYan.json;

import com.alibaba.fastjson2.JSON;

public class FastJsonDemo {

    public static void main(String[] args) {
        //1. Java object to Json String
        User user = new User();
        user.setId(1);
        user.setUsername("XiuYan");
        user.setPassword("123");

        String toJSONString = JSON.toJSONString(user);
        System.out.println(toJSONString);


        //2. Json String to Java object
        User user1 = JSON.parseObject(toJSONString, User.class);
        System.out.println(user1);
    }


}
