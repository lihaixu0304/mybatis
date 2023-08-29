package com.mybatis;

import com.mybatis.mapper.CarMapper;
import com.mybatis.pojo.Car;
import com.mybatis.utils.MyBatisUtils;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/29 17:49
 */
public class Test01 {
    /*
     * #{}的使用
     *
     * */
    @Test
    public void selectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("燃油车");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
/*
* #{}的使用
*
* */
    @Test
    public void selectByCarNum(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarNum("A01");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
/*
* SQL语句中的关键字必须使用${}
* */
    @Test
    public void asc(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByGuidePrice("asc");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
}
