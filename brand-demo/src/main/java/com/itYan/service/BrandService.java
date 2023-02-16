package com.itYan.service;

import com.itYan.mapper.BrandMapper;
import com.itYan.pojo.Brand;
import com.itYan.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    //1. 調用BrandMapper.selectAll()
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    /**
     * 查詢所有
     * @return brands
     */
    public List<Brand> selectAll() {

        //2. 獲取sqlSession 對象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 獲取BrandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 調用方法
        List<Brand> brands = brandMapper.selectAll();

        //5. release resource
        sqlSession.close();

        //6. 回傳結果
        return brands;

    }

    /**
     * 添加數據
     * @return void
     */
    public void add(Brand brand) {

        //2. 獲取sqlSession 對象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 獲取BrandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.add(brand);

        //4. 提交事務
        sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }

    /**
     * 根據 id 查詢
     * @return brands
     */
    public Brand selectById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);

        sqlSession.close();

        return brand;
    }

    /**
     * 修改數據
     * @return void
     */
    public void update(Brand brand) {

        //2. 獲取sqlSession 對象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. 獲取BrandMapper
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.update(brand);

        //4. 提交事務
        sqlSession.commit();

        //5. release resource
        sqlSession.close();
    }

    public void deleteById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();

    }
}
