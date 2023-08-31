package com.mybatis.maptest;

import com.mybatis.mapper.CarMapper;
import com.mybatis.pojo.Car;
import com.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author lihaixu
 * @Date 2023/8/30 14:24
 */
public class MapTest {
    CarMapper mapper = SqlSessionUtil.openSession().getMapper(CarMapper.class);
    @Test
    public void selectAllMap(){
        Map<Long, Map<String, Objects>> longMapMap = mapper.selectAllMap();
        System.out.println(longMapMap);
    }

    @Test
    public void selectAllList(){
        List<Map<String, Objects>> maps = mapper.selectAllList();
        System.out.println(maps);
    }
    @Test
    public void selectResultMap(){
        List<Car> cars = mapper.selectResultMap();
        System.out.println(cars);
    }
}
