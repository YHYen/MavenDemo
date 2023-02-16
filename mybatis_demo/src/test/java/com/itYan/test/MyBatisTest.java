package com.itYan.test;

import com.itYan.mapper.BrandMapper;
import com.itYan.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {
    @Test
    public void testSelectAll() throws IOException {
        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testSelectById() throws IOException {
        //0. get variable id
        int id = 1;

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testSelectByCondition() throws IOException {
        //0. get variable
        int status = 0;
        String companyName = "宏碁";
        String brandName = "宏碁";

        //0.1. variable processing
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //0.2. package object
        //Brand brand = new Brand();
        //brand.setStatus(status);
        //brand.setCompanyName(companyName);
        //brand.setBrandName(brandName);

        Map map = new HashMap();
        map.put("status", status);
        map.put("companyName", companyName);
        map.put("brandName", brandName);

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
       List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testSelectByConditionSingle() throws IOException {
        //0. get variable
        int status = 0;
        String companyName = "宏碁";
        String brandName = "宏碁";

        //0.1. variable processing
        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";

        //0.2. package object
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testAdd() throws IOException {
        //0. get variable
        int status = 0;
        String companyName = "全家";
        String brandName = "全家便利商店";
        String description = "全家就是你家";
        int ordered = 500;


        //0.1. package object
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        brandMapper.add(brand);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testUpdate() throws IOException {
        //0. get variable
        int status = 1;
        String companyName = "義美";
        String brandName = "義美食品";
        String description = "好食品的供應者";
        int ordered = 400;
        int id = 8;


        //0.1. package object
        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);
        brand.setId(id);

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        brandMapper.update(brand);

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testDeleteById() throws IOException {
        //0. get variable
        int id = 6;

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        brandMapper.deleteById(id);
        sqlSession.commit();

        //5. release resource
        sqlSession.close();

    }

    @Test
    public void testDeleteByIds() throws IOException {
        //0. get variable
        int[] ids = {7, 9, 10};

        //1. Loading MyBatis config file, and get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get Mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute sql query function
        brandMapper.deleteByIds(ids);
        sqlSession.commit();

        //5. release resource
        sqlSession.close();

    }
}
