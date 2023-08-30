package com.mybatis.mapper;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/30 08:59
 */
public interface StudentMapper {
    /*
    * 查询单个学生信息，根据id
    * */
    List<Student> selectById(Long id);
    /*
    * 查询单个学生信息，根据birth
    * */
    List<Student> selectByBirth(Date birth);
    /*
    * 查询单个学生信息，根据sex
    * */
    List<Student> selectBySex(Character sex);
    /*
    * 查询单个学生信息，根据name
    * */
    List<Student> selectByName(String name);
    /*
    * 模糊查询
    * 姓李
    * */
    List<Student> selectByLikeName(String name);
    /*
    * 多参数查询
    * */
    List<Student> selectByidAndSex(Long id,Character sex);

    /*
    *
    * 注解形式的参数查询
    * */
    List<Student> selectByNameAndAge(@Param(value = "name") String name,@Param(value = "sex")Character sex);
}
