package com.mybatis.mapper;

import com.mybatis.pojo.Car;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @Author lihaixu
 * @Date 2023/8/30 11:54
 */
public interface CarMapper {
    /*
    * 将查询结果返回成一个map集合
    * 解决异常Expected one result (or null) to be returned by selectOne(), but found: 6
    * 要加注解
    * */
   @MapKey("id")
    Map<Long ,Map<String, Objects>> selectAllMap();

   /*
   * 将查询结果返回成一个list的map集合
   * */
    List<Map<String,Objects>> selectAllList();

    /*
    * resultMap结果映射方式
    *     * */
    List<Car> selectResultMap();
}
