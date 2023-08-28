package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @Author lihaixu
 * @Date 2023/8/28 16:47
 */
public class MyBatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
  static {
      try {
          SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
          sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
      }catch (Exception e){
          e.printStackTrace();
      }
  }

  public static SqlSession sqlSession(){
      //开启事务自动提交
      return sqlSessionFactory.openSession(true);
  }

}
