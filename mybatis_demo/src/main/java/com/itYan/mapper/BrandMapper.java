package com.itYan.mapper;

import com.itYan.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {

    /*
    * Search all data
    * */
    List<Brand> selectAll();

    Brand selectById(int id);

    ///**
    //*  * 多參數接收
    //*       1. 散裝參數: 如果方法中有多個參數，需要使用@Param("SQL參數站未符名稱")
    //*       2. 對象參數
    //*       3. map集合參數
    //*
    //*  @param status
    //*  @param companyName
    //*  @param brandName
    //*  @return
    //* */
    // List<Brand> selectByCondition(@Param("status")int status, @Param("companyName")String companyName, @Param("brandName")String brandName);
    // List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition(Map map);

    List<Brand> selectByConditionSingle(Brand brand);

    // insert
    void add(Brand brand);

    //update
    void update(Brand brand);

    void deleteById(int id);

    void deleteByIds(@Param("ids")int[] ids);
}
