package com.mybatis.mapper;

import com.mybatis.pojo.Car;

import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/29 17:52
 */
public interface CarMapper {
    /*
    *
    * 根据类型进行查询
    * */
    List<Car> selectByCarType(String carType);

    /*
    * 根据id进行查询
    * */

    List<Car> selectByCarNum(String carNum);

    /*
    * 根据关键字排序
    * */
    List<Car> selectByGuidePrice(String ascKey);
}
