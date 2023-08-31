package com.mybatis.proxytest;

import com.mybatisproxy.mapper.CarMapper;
import com.mybatisproxy.pojo.Car;
import com.mybatisproxy.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/30 21:20
 */
public class ProxyTest {
    CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
    @Test
    public void testIf(){
        List<Car> cars = mapper.selectByIf("MG7", 20.0, "燃油车");
        System.out.println(cars);

    }
    @Test
    public void testWhere(){
        List<Car> cars = mapper.selectByWhere("", null, null);
        System.out.println(cars);
    }
    @Test
    public void testTrim(){
        List<Car> cars = mapper.selectByTrim("奔驰",null,"");
        System.out.println(cars);
    }
}
