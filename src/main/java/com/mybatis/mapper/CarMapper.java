package com.mybatis.mapper;

import com.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/29 17:13
 */
public interface CarMapper {
/*
* 根据汽车类型进行查找
*
* */
    List<Car> selectByCarType(String carType);
}
