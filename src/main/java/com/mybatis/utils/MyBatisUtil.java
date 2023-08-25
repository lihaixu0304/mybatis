package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

/**
 * Author:李海旭
 * Date : 2023/8/25 16:15
 */
public class MyBatisUtil {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
            sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession sqlSession(){
        //开启事务自动提交
        return sqlSessionFactory.openSession(true);
    }
}
