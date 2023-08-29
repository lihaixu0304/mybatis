package com.mybatis.test;

import com.mybatis.mapper.CarMapper;
import com.mybatis.pojo.Car;
import com.mybatis.utils.MyBatisUtil;
import com.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author:李海旭
 * Date : 2023/8/25 16:39
 */
public class MyBatisTest {
    //插入记录
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
//删除记录
    @Test
    public void delete(){
        SqlSession sqlSession = MyBatisUtil.sqlSession();
        int deleteCarById = sqlSession.delete("deleteCarById", 7);
        System.out.println("删除记录数："+deleteCarById);
        sqlSession.commit();
        sqlSession.close();
    }
//更新记录
    @Test
    public void update(){
        SqlSession sqlSession = MyBatisUtil.sqlSession();
        Car car = new Car(6L,null,"保时捷911",null,null,null);
        int updateCar = sqlSession.update("updateCar", car);
        System.out.println("修改条数："+updateCar);
        sqlSession.commit();
        sqlSession.close();
    }
    //查询单条记录
    @Test
    public void select(){
        SqlSession sqlSession = MyBatisUtil.sqlSession();
        Object selectCarById = sqlSession.selectOne("selectCarById", 1);
        System.out.println("查询结果为："+selectCarById);
        sqlSession.close();
    }
//查询所有数据
    @Test
    public void selectAll(){
        SqlSession sqlSession = MyBatisUtil.sqlSession();
        List<Object> selectAllCar = sqlSession.selectList("selectAllCar");
        selectAllCar.forEach(car -> System.out.println(car));
        sqlSession.close();
    }
//多环境配置
    @Test
    public void environment() throws Exception{
        /*
         * 多环境配置
         * 不同的环境需要不同的sqlSessionFactory
         * 环境1：development
         * 环境2：test
         * */
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //环境1
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        Object selectCarById = sqlSession.selectOne("selectCarById");
        System.out.println("查询记录数："+selectCarById);

        /*
        * 环境2,因为默认环境为environment，
        * 要使用test环境，所以在
        * getResourceAsReader()方法中不仅要指定mybatis配置文件，同时也要指定环境id
        * */
        SqlSessionFactory sqlSessionFactory1 = sqlSessionFactoryBuilder.build(Resources.getResourceAsReader("mybatis-config.xml"), "test");
        SqlSession sqlSession1 = sqlSessionFactory1.openSession(true);
        int updateCar = sqlSession1.update("updateCar");
        System.out.println("更新记录数为："+updateCar);
        sqlSession.close();
    }
    
    @Test
    public void testSelectByCarType(){
        CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("燃油车");
        cars.forEach(car -> System.out.println(car));

    }
}
