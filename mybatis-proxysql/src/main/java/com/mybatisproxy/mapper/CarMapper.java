package com.mybatisproxy.mapper;

import com.mybatisproxy.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/30 16:00
 */
public interface CarMapper {
    /*
    * 动态sql之if标签
    * 适用于多条件查询
    * */
    List<Car> selectByIf(@Param("brand")String brand,@Param("guidePrice") Double guidePrice,@Param("carType")String carType);

    /*
    * 动态SQL之where标签
    * 让where后面的语句更加灵活
    * */
    List<Car> selectByWhere(@Param(value = "brand")String brand, @Param(value = "guidePrice") Double guidePrice,@Param(value = "carType")String carType);
    /*
    *
    * 动态SQL之trim标签
    * 这个标签有4个属性：
    *           prefix在标签中添加前置内容,
    *           suffix在标签中添加后置内容,
    *           prefixOverrides前置标签覆盖,
    *           suffixOverrides后置标签覆盖
    * */
    List<Car> selectByTrim(@Param(value = "brand")String brand,@Param(value = "guidePrice")Double GguidePrice,@Param(value = "carType") String carType);
}
