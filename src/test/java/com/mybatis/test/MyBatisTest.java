package com.mybatis.test;

import com.mybatis.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Author:李海旭
 * Date : 2023/8/25 16:39
 */
public class MyBatisTest {
    @Test
    public void insert(){
        //集合传值
        Map<String,Object> map = new HashMap<>();
        map.put("carNum","A08");
        map.put("brand","坦克300");
        map.put("guidePrice",44.99);
        map.put("produceTime","2023-12-23");
        map.put("carType","燃油车");
        SqlSession sqlSession = MyBatisUtil.sqlSession();
        int insertCar = sqlSession.insert("insertCar", map);
        System.out.println("插入记录"+insertCar);
        sqlSession.commit();
        sqlSession.close();
    }
}
