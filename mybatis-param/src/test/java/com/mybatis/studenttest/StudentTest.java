package com.mybatis.studenttest;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.pojo.Student;
import com.mybatis.utils.SqlSessionUtil;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author lihaixu
 * @Date 2023/8/30 09:11
 */
public class StudentTest {
    StudentMapper mapper = SqlSessionUtil.openSession().getMapper(StudentMapper.class);
    @Test
    public void selectById(){

        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> System.out.println(student));

    }
@Test
    public void selectByBirth(){
    try {
        Date birth = new SimpleDateFormat("yyyy-MM-dd").parse("1997-08-22");
        List<Student> students = mapper.selectByBirth(birth);
        students.forEach(student -> System.out.println(student));
    } catch (ParseException e) {
        throw new RuntimeException(e);
    }
    }
    @Test
    public void selectBySex(){
        List<Student> students = mapper.selectBySex('男');
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectByName(){
        List<Student> students = mapper.selectByName("鸡枞");
        students.forEach(student -> System.out.println(student));
    }
    @Test
    public void selectByLikeName(){
        List<Student> students = mapper.selectByLikeName("李");
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectByIdAndSex(){
        List<Student> students = mapper.selectByidAndSex(7L, '男');
        students.forEach(student -> System.out.println(student));
    }

    @Test
    public void selectByNameAndSex(){
        List<Student> students = mapper.selectByNameAndAge("张三", '男');
        students.forEach(student -> System.out.println(student));
    }
}
